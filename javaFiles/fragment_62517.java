MariaDB [test]> set @v1 = "'city', 'ITY', 'age', '20'";
Query OK, 0 rows affected (0.01 sec)

MariaDB [test]> set @q = concat("insert into test values(11, 'hidy', column_create(",@v1,"))");
Query OK, 0 rows affected (0.00 sec)

MariaDB [test]> select @q;
+--------------------------------------------------------------------------------+
| @q                                                                             |
+--------------------------------------------------------------------------------+
| insert into test values(11, 'hidy', column_create('city', 'ITY', 'age', '20')) |
+--------------------------------------------------------------------------------+
1 row in set (0.00 sec)

MariaDB [test]> prepare stmt from @q;
Query OK, 0 rows affected (0.00 sec)
Statement prepared

MariaDB [test]> execute stmt;
Query OK, 1 row affected (0.26 sec)

MariaDB [test]> select column_get(b,'city' as char(8)) from test;
+---------------------------------+
| column_get(b,'city' as char(8)) |
+---------------------------------+
| ITY                             |
+---------------------------------+
1 row in set (0.00 sec)