create table address(
    id serial primary key,
    street text not null
    -- other fields, etc
); 
create table student(
    id serial primary key,
    name text not null,
    grade int not null,
    address_id not null references address(id)
    -- ...
);
create table hobby(
    id serial primary key,
    student_id not null references student(id),
    name text
    -- ...
);