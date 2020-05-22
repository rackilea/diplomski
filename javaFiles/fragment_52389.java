Dataset<Row> rowDataset = sc.read().json("path");
Dataset<Tweet> tweetDataset = rowDataset
                .withColumn("id", rowDataset.col("id").cast(DataTypes.LongType))
                .as(Encoders.bean(Tweet.class));
tweetDataset.printSchema();
System.out.println(tweetDataset.head().getId());