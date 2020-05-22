Dataset<Row> df = spark.range(10)
    .select(col("id"),
             when(col("id").mod(2).equalTo(lit(0)), null )
                 .otherwise(col("id").cast("string")).as("string_col"),
             when(col("id").mod(2).equalTo(lit(0)), null )
                 .otherwise(col("id")).as("int_col"));

df.na().fill("").show();