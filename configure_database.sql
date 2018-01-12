drop database if exists airbnb;
drop user if exists airbnb_user;

create user airbnb_user with password 'airbnb';

create database airbnb owner airbnb_user; 
\connect airbnb;

drop table if exists AIRBNB_DATA;

create table AIRBNB_DATA (
	id SERIAL,
	room_id varchar(40),
	host_id varchar(40),
	room_type varchar(100),
	borough varchar(100),
	neighborhood varchar(100),
	reviews integer,
	overall_satisfaction real,
	accommodates integer,
	bedrooms integer,
	price real,
	minstay integer,
	latitude real,
	longitude real,
	last_modified timestamp
);

alter table AIRBNB_DATA owner to airbnb_user;
