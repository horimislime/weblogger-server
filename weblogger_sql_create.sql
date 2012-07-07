create table log(
id bigint(32) not null primary key auto_increment,
userid int not null,
url varchar(1024),
title varchar(256),
insert_datetime timestamp,
access_datetime timestamp
);
