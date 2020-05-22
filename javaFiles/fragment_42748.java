Dataset<Row> result = responseDataset
    .withColumn("userI", when(col("isInstall").equalTo(1), col("user")))
    .withColumn("userP", when(col("isPlayed").equalTo(1), col("user")))
    .groupBy("day")
    .agg(countDistinct(col("userP")).alias("isPlayedUU"),
         countDistinct(col("userI")).alias("isInstallUU"));