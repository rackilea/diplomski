create table thing7
(   id int auto_increment primary key,
    A int not null,
    B int not null,
    C int not null,
    index(A,B,C) -- covering index (uber-thin, uber-fast)
);

insert thing7(A,B,C) values
(1,2,7),  
(1,2,8), 
(2,2,1), 
(1,3,1);

create table A
(   id int auto_increment primary key,
    value int
);
create table B
(   id int auto_increment primary key,
    value int
);
create table C
(   id int auto_increment primary key,
    value int
);