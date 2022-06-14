drop table if exists users;

create table users (
    seq         bigint not null AUTO_INCREMENT,
    id          varchar(255) not null,
    password    varchar(255) not null,
    name        varchar(255) not null,
    role        varchar(32) not null,
    primary key (seq)
);