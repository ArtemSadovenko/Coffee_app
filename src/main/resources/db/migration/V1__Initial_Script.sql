use coffee_shop;

drop table if exists `user`;
create table `user`(
	id bigint auto_increment primary key,
    `name` varchar(255),
    user_role enum('CONSUMER','ADMIN')
)auto_increment = 0;

drop table if exists coffee;
create table `coffee`(
	id bigint auto_increment primary key,
    `name` varchar(255),
    amount int
--     user_id bigint,
--     foreign key (user_id) references `user`(id)
)auto_increment = 0;

drop table if exists topping;
create table topping(
	id bigint auto_increment primary key,
    `name` varchar(255),
    amount int,
    user_id bigint,
    foreign key (user_id) references `user`(id)
)auto_increment = 0;