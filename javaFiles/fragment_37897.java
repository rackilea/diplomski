create table Users (
  id int,
  name varchar(20)
);

create type UserTableType as table (
  id int,
  name varchar(20)
);

create procedure uspAddUsers
  @UserTable UserTableType READONLY
as
begin
    insert into Users (id, name)
      select * from @UserTable
end;