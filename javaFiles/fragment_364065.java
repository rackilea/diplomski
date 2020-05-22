ij> create table "APP".REGISTRATION
> (
>   "id" INT not null primary key GENERATED ALWAYS AS IDENTITY(START WITH 1,INCREMENT BY 1),
>   "firstname" VARCHAR(50),
>   "lastname" VARCHAR(50),
>   "username" VARCHAR(50),
>   "password" VARCHAR(50),
>   "email" VARCHAR(50)
> );
0 rows inserted/updated/deleted
ij> select * from "APP".registration where username = 'susheel61';
ERROR 42X04: Column 'USERNAME' is either not in any table in the FROM list or appears within a join specification and is outside the scope of the join specification or appears in a HAVING clause and is not in the GROUP BY list. If this is a CREATE or ALTER TABLE  statement then 'USERNAME' is not a column in the target table.
ij> select * from "APP".registration where "username" = 'susheel61';
id         |firstname                                         |lastname                                          |username                                                  |password                                          |email
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

0 rows selected
ij>