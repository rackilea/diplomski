df = df.select("*")
       .withColumn("distance", callUDF("calcDistance",
                df.col("latitude"),
                df.col("longitude"),
                df.col("mean_lat"),
                df.col("mean_lon")))
      .toDF();