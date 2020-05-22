Dataset<Row> result1 = responseDataset
    .filter(col("isInstall").equalTo(1))
    .groupBy("Day")
    .agg(countDistinct("User").alias("isInstallUU"));

Dataset<Row> result2 = responseDataset
    .filter(col("isPlayed").equalTo(1))
    .groupBy("Day")
    .agg(countDistinct("User").alias("isPlayedUU"));

Dataset<Row> result = result1
    .join(result2, result1.col("Day").equalTo(result1.col("Day")), "full_outer")
    .na().fill(0);