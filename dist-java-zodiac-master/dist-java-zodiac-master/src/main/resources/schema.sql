create table fortune
(
    fortune_id int primary key,
    text       varchar(1000) not null
);

create table calendar_month
(
    num int primary key,
    nm  varchar(75) not null
);