df = df
    .withColumn(
        "date",
        date_format(col("time"), "yyyy-MM-dd HH:mm:ss.SSSS"))
    .withColumn("h", hour(col("date")))
    .withColumn("m", minute(col("date")))
    .withColumn("s", second(col("date")))
    .withColumn("event", expr("h*3600 + m*60 +s"))
    .drop("date")
    .drop("h")
    .drop("m")
    .drop("s");