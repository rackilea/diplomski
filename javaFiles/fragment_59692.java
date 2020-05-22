val ds1 = Seq(("hello", 1.56, 34)).toDF("name", "ratio", "count")
val recordCol = to_json(struct("name", "ratio", "count")) as "record"
scala> ds1.select(recordCol).show(truncate = false)
+----------------------------------------+
|record                                  |
+----------------------------------------+
|{"name":"hello","ratio":1.56,"count":34}|
+----------------------------------------+