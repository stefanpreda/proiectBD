# proiectBD

# POSTGRES

TO RUN THE SCRIPT:
sudo -u postgres psql < configure_database.sql

TO CONNECT WITH USER TO DATABASE:
sudo -u postgres psql -U airbnb_user -h 127.0.0.1 -d airbnb

TO DISPLAY TABLES USE:
\dt

TO VIEW TABLE STRUCTURE:
\d+ airbnb_data


# DATA2DB

BUILD: mvn clean verify

RUN: cd target; java -jar data2db-0.0.1-SNAPSHOT-jar-with-dependencies.jar ../input/tomslee_airbnb_amsterdam_0443_2016-05-31.csv

# retrieverService

cd retrieverService

mvn compile vertx:run

The retriever server is available at localhost:8080

# Dashboard 

cd dashboard

npm start

The dashboard is available at localhost:3000

