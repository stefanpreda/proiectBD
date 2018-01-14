package com.proiectBD;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.PostgreSQLClient;
import io.vertx.ext.sql.SQLConnection;

import java.util.List;

public class DataBaseService {

    private AsyncSQLClient dbClient;

    private String statement = " ";


    //BEDROOMS - NUMBER OF ROOMS
    private String statsBedrooms = "select bedrooms, count(distinct room_id) from airbnb_data group by bedrooms;";

    //ROOM TYPE - COUNT ROOMS
    private String statsRooms = "select room_type, count(distinct room_id) from airbnb_data group by room_type;";

    //NEIGHBORHOOD - COUNT ROOMS
    private String statsNeighborhood = "select neighborhood, count(distinct room_id) from airbnb_data group by neighborhood;";

    public void init(Handler<AsyncResult<Void>> handler, JsonObject config, Vertx vertx) {
        dbClient = PostgreSQLClient.createNonShared(vertx, config);
        dbClient.getConnection(ar -> {
            if (ar.succeeded()) {
                System.out.println("connected to the database");
                handler.handle(Future.succeededFuture());
            } else {
                System.out.println("something went wrong when connecting to database");
                handler.handle(Future.failedFuture("not able to connect"));
            }
        });
    }


    public void getStatsNeighborhood(Handler<AsyncResult<JsonObject>> handler) {

        dbClient.getConnection(ar -> {
            if (ar.succeeded()) {
                SQLConnection connection = ar.result();
                connection.query(statsNeighborhood, result-> {
                    if (result.succeeded()) {
                        System.out.println("succeded statement: " + statsNeighborhood);
                        List<JsonArray> rows = result.result().getResults();
                        JsonObject returned = new JsonObject();
                        System.out.println("returned from db " + rows);
                        for (JsonArray row : rows) {
                           returned.put(row.getString(0), row.getInteger(1).toString());
                        }
                        handler.handle(Future.succeededFuture(returned));
                    }
                    else {
                        handler.handle(Future.failedFuture(result.cause()));
                        System.out.println("Something went wrong with statement:" + statsNeighborhood + " " + result.cause());
                    }
                    connection.close();
                });
            }
            else {
                System.out.println("error while connecting to the database");
            }
        });
    }
    public void getStatsRooms(Handler<AsyncResult<JsonObject>> handler) {
        dbClient.getConnection(ar -> {
            if (ar.succeeded()) {
                SQLConnection connection = ar.result();
                connection.query(statsRooms, result-> {
                    if (result.succeeded()) {
                        System.out.println("succeded statement: " + statsRooms);
                        List<JsonArray> rows = result.result().getResults();
                        JsonObject returned = new JsonObject();
                        System.out.println("returned from db " + rows);

                        int total = 0;
                        for (JsonArray row : rows) {
                            total += row.getInteger(1);
                        }

                        System.out.println("total " + total);
                        for (JsonArray row : rows ) {
                            Float percentage = (float)row.getInteger(1) / total * 100L;
                            if (row.getString(0) != null) {
                                returned.put(row.getString(0), percentage.toString());
                            }
                            else {
                                returned.put("undefined", percentage.toString());
                            }
                        }
                        handler.handle(Future.succeededFuture(returned));
                    }
                    else {
                        handler.handle(Future.failedFuture(result.cause()));
                        System.out.println("Something went wrong with statement:" + statsRooms + " " + result.cause());
                    }
                    connection.close();
                });
            }
            else {
                System.out.println("error while connecting to the database");
            }
        });
    }
    public void getStatsBedrooms(Handler<AsyncResult<JsonObject>> handler) {
        dbClient.getConnection(ar -> {
            if (ar.succeeded()) {
                SQLConnection connection = ar.result();
                connection.query(statsBedrooms, result-> {
                    if (result.succeeded()) {
                        System.out.println("succeded statement: " + statement);
                        List<JsonArray> rows = result.result().getResults();
                        JsonObject returned = new JsonObject();
                        System.out.println("returned from db " + rows);
                        for (JsonArray row : rows) {
                            if (row.getInteger(0) != null)
                                returned.put(row.getInteger(0).toString(), row.getInteger(1).toString());
                            else
                                returned.put("undefined", row.getInteger(1).toString());
                        }
                        handler.handle(Future.succeededFuture(returned));
                    }
                    else {
                        handler.handle(Future.failedFuture(result.cause()));
                        System.out.println("Something went wrong with statement:" + statement + " " + result.cause());
                    }
                    connection.close();
                });
            }
            else {
                System.out.println("error while connecting to the database");
            }
        });
    }

}
