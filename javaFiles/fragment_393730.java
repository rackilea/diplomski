scala> import org.apache.spark.sql.expressions.{UserDefinedFunction, Window}

scala> val key1 = 2

scala> val key2 = 4

scala> def repeatudf:UserDefinedFunction = udf((key:Int) => {var out = "1"
     | val rng = 1 to (key-1)
     | for (i <- rng) {out = out + "," + "1"}
     | out
     | })

scala> df.show
+----+----+
|col1|col2|
+----+----+
|   a|   a|
|   a|   b|
|   b|   c|
|   c|   d|
+----+----+


scala> val df1 =  df.withColumn("map", when(col("col1") === "a" || col("col2") === "a",  repeatudf(lit(key1))).otherwise(repeatudf(lit(key2))))
                    .withColumn("map", explode(split(col("map"), ",")))
                    .drop("map")

scala> df1.show()
+----+----+
|col1|col2|
+----+----+
|   a|   a|
|   a|   a|
|   a|   b|
|   a|   b|
|   b|   c|
|   b|   c|
|   b|   c|
|   b|   c|
|   c|   d|
|   c|   d|
|   c|   d|
|   c|   d|
+----+----+

scala> val w =  Window.orderBy(col("col1"), col("col2"))

scala> df1.withColumn("limit_fact", row_number.over(w)).show
+----+----+----------+
|col1|col2|limit_fact|
+----+----+----------+
|   a|   a|         1|
|   a|   a|         2|
|   a|   b|         3|
|   a|   b|         4|
|   b|   c|         5|
|   b|   c|         6|
|   b|   c|         7|
|   b|   c|         8|
|   c|   d|         9|
|   c|   d|        10|
|   c|   d|        11|
|   c|   d|        12|
+----+----+----------+