mysql> select * from tags;
+-------+---------+
| tagId | tagName |
+-------+---------+
|    11 | java    |
+-------+---------+
1 row in set (0.00 sec)

mysql> select * from task_tags;
+--------+-------+
| taskId | tagId |
+--------+-------+
|     11 |    11 |
|     12 |    11 |
+--------+-------+
2 rows in set (0.00 sec)