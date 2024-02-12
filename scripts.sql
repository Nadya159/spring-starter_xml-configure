create database test_base;

create table company
(
    id serial primary key,
    name varchar(128) not null
);

create table users
(
    id serial primary key,
    username varchar(128) not null,
    company_id int references company(id)
);

insert into company (name)
values ('Microsoft'),
       ('Apple'),
       ('Google');

insert into users (username, company_id)
values ('Bill Gates', 1),
       ('Steve Jobs', 2),
       ('Sergey Brin', 3),
       ('Tim Cook', 1),
       ('Diane Greene', 3);
