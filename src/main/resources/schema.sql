drop table if exists book;

create table book
(
    id          bigint auto_increment,
    description varchar(255),
    author      varchar(255),
    title       varchar(255),
    isbn        varchar(255),
    reader      varchar(255),
    primary key (id)
);

insert into book (description, author, title, isbn, reader, id)
values ('d', 'a', 't', 'i', 'craig', 1);