select * from tab;

create table joinmember(
    id varchar(15) primary key,
    name varchar(15) not null,
    password varchar(20) not null,
    nickname varchar(15) not null
);

select * from joinmember;

desc joinmember;
