drop table if exists products;

create table products
(
  id         serial primary key,
  name       varchar (100) NOT null,
  description    varchar (1000) NOT null
);