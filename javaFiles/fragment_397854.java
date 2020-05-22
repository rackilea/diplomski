SQL> create table myorder
  2    ("DATE"   date,
  3     "SUM"    number
  4    );

Table created.

SQL> -- this is what you are currently doing; see? The same ORA-01747 error
SQL> select this_.date,
  2         this_.sum
  3  from myorder this_;
select this_.date,
             *
ERROR at line 1:
ORA-01747: invalid user.table.column, table.column, or column specification

SQL> -- this is what you should be doing
SQL> select this_."DATE",
  2         this_."SUM"
  3  from myorder this_;

no rows selected

SQL>