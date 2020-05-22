df1.alias("x").join(df2.alias("y").select(col("y.Col1").alias("newCol1")), col("x.Col1") === regexp_extract(col("newCol1"),"\\p{L}+(?: \\p{L}+)*$",0), "left")
              .withColumn("Col1", col("newCol1"))
              .join(df2.alias("z").select(col("z.Col2").alias("newCol2")), col("x.Col2") === regexp_extract(col("newCol2"),"\\p{L}+(?: \\p{L}+)*$",0), "left")
              .withColumn("Col2", col("newCol2"))
              .drop("newCol1", "newCol2")
              .show(false)

+----+----+----+
|Col1|Col2|Col3|
+----+----+----+
|2-C |1-x |o   |
|0-A |0-z |m   |
|0-A |0-z |n   |
|0-A |2-p |o   |
|1-B |3-w |n   |
+----+----+----+