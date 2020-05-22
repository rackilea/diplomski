StreamingQuery ds = df
                        .select(functions.from_json(col("value").cast(DataTypes.StringType),schema).as("data"))
                        .select("data.*")
                        .writeStream()
                        .format("json")
                        .outputMode(OutputMode.Append())
                        .option("path", destPath)
                        .option("checkpointLocation", checkpoint)
                        .start();