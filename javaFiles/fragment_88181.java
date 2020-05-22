postgres=# set extra_float_digits = 2;
SET
postgres=# select extract(epoch from current_timestamp(3));
     date_part      
--------------------
 1355346251.7550001
(1 row)

postgres=# select extract(epoch from current_timestamp(3));
     date_part      
--------------------
 1355346253.1619999
(1 row)