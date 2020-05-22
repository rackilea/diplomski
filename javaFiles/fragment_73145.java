mysql> SHOW SESSION STATUS LIKE 'Handler%';
+----------------------------+-------+
| Variable_name              | Value |
+----------------------------+-------+
| Handler_commit             | 1     |
| Handler_delete             | 0     |
| Handler_discover           | 0     |
| Handler_external_lock      | 4     |
| Handler_mrr_init           | 0     |
| Handler_prepare            | 0     |
| Handler_read_first         | 1     |
| Handler_read_key           | 21    |  -- about 20
| Handler_read_last          | 0     |
| Handler_read_next          | 319   |  -- about 300+20 (OFFSET+LIMIT)
| Handler_read_prev          | 0     |
| Handler_read_rnd           | 0     |
| Handler_read_rnd_next      | 21    |  -- about 20
| Handler_rollback           | 0     |
| Handler_savepoint          | 0     |
| Handler_savepoint_rollback | 0     |
| Handler_update             | 0     |
| Handler_write              | 20    |  -- 20  (the 'derived' table)
+----------------------------+-------+
18 rows in set (0.00 sec)