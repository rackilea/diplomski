rdd_part
  .mapPartitionsWithIndex{case (i,rows) => Iterator((i,rows.size))}
  .toDF("partition_number","number_of_records")
  .show

/**
+----------------+-----------------+
|               0|               70|
|               1|               70|
|               2|               70|
|               3|               70|
|               4|               70|
|               5|               70|
|               6|               70|
|               7|               70|
|               8|               70|
|               9|               70|
|              10|               70|
|              11|               70|
|              12|               70|
|              13|               70|
|              14|               20|
+----------------+-----------------+
*/