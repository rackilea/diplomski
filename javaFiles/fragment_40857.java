mysql> select * from defaultaccounts;
+----+---------------+----------+
| id | email         | password |
+----+---------------+----------+
|  1 | test@test.com | test     |
+----+---------------+----------+
1 row in set (0.00 sec)

mysql> select * from default_account_manager_acc;
+-----------------+------------------+
| default_account | manager_accounts |
+-----------------+------------------+
|               1 |            10001 |
|               1 |            10000 |
|               1 |            10002 |
+-----------------+------------------+
3 rows in set (0.00 sec)