package com.proiectBD;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class HttpVerticle extends AbstractVerticle {

    private DataBaseService dataBaseService = new DataBaseService();

    @Override
    public void start(Future<Void> startFuture) {

        Router router = Router.router(vertx);
                router.route().handler(BodyHandler.create());
                router.get("/").handler(rc -> {
                rc.response().end("Welcome to retriever service");
            });
        router.get("/statsbedrooms").handler(this::getStatsBedrooms);
        router.get("/statsrooms").handler(this::getStatsRooms);
        router.get("/neighborhood").handler(this::getStatsNeighborhood);

        vertx.createHttpServer()
            .requestHandler(router::accept)
            .listen(8080);

        JsonObject config = new JsonObject()
                .put("host", "localhost")
                .put("username", "airbnb_user")
                .put("password", "airbnb")
                .put("database", "airbnb");

        Future<Void> dbFuture = Future.future();

        dataBaseService.init(dbFuture.completer(), config, vertx);
        dbFuture.setHandler(ar -> {
            if (ar.succeeded()) {
                startFuture.complete();
            }
            else {
                System.out.println("could not get db from verticle " + ar.cause());
                startFuture.fail(ar.cause());
            }
        });

    }

    private void getStatsNeighborhood(RoutingContext rc) {
        dataBaseService.getStatsNeighborhood(result -> {
            if (result.succeeded()) {
                JsonObject json = result.result();
                System.out.println("got response from db " + json);
                rc.response().setStatusCode(200).putHeader("Access-Control-Allow-Origin", "*").end(json.encodePrettily());
            }
            else {
                rc.response().setStatusCode(500).end();
            }
        });
    }

    private void getStatsBedrooms(RoutingContext rc) {

        dataBaseService.getStatsBedrooms(result -> {
            if (result.succeeded()) {
                JsonObject json = result.result();
                System.out.println("got response from db " + json);
                rc.response().setStatusCode(200).putHeader("Access-Control-Allow-Origin", "*").end(json.encodePrettily());
            }
            else {
                rc.response().setStatusCode(500).end();
            }
        });
    }


    private void getStatsRooms(RoutingContext rc) {

        dataBaseService.getStatsRooms(result -> {
            if (result.succeeded()) {
                JsonObject json = result.result();
                System.out.println("got response from db " + json);
                rc.response().setStatusCode(200).putHeader("Access-Control-Allow-Origin", "*").end(json.encode());
            }
            else {
                rc.response().setStatusCode(500).end();
            }
        });
    }
}
