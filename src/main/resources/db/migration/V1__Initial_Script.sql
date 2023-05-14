drop database if exists coffee_shop;
create database coffee_shop;

use coffee_shop;

drop table if exists `user`;
create table `user`(
	id bigint auto_increment primary key,
    `name` varchar(255),
    user_role enum('CONSUMER','ADMIN')
)auto_increment = 0;

drop table if exists `coffee`;
create table `coffee`(
	id bigint auto_increment primary key,
    `name` varchar(255),
    amount int
--     user_id bigint,
--     foreign key (user_id) references `user`(id)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4;

drop table if exists `coffee_bill`;
create table `coffee_bill`(
	id bigint auto_increment primary key,
    `name` varchar(255),
    amount int,
    user_id bigint,
    foreign key (user_id) references `user`(id)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4;




drop table if exists topping;
create table topping(
	id bigint auto_increment primary key,
    `name` varchar(255),
    amount int
--     user_id bigint,
--     foreign key (user_id) references `user`(id)
)auto_increment = 0;

drop table if exists `topping_bill`;
create table `topping_bill`(
	id bigint auto_increment primary key,
    `name` varchar(255),
    amount int,
    user_id bigint,
    foreign key (user_id) references `user`(id)
)auto_increment = 0;