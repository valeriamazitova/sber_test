create table Person(
                       id int primary key generated by default as identity,
                       name varchar(100) not null,
                       age int check ( age < 100 )
);

create table Item(
                     id int primary key generated by default as identity,
                     person_id int references Person(id) on delete set null,
                     item_name varchar(100) not null
);

drop table Person cascade;
drop table Item cascade;

insert into Person (name, age)
values ('Tom', 35),
       ('Bob', 52),
       ('Kate', 14);

insert into Item(person_id, item_name) values (1, 'book'),
                                              (1, 'airpods'),
                                              (2, 'iphone'),
                                              (3, 'kindle'),
                                              (3, 'tv'),
                                              (3, 'playstation');

select * from item;
select * from person;