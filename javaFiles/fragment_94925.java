Object obj = new JSONParser().parse(new FileReader("json path"));
        JSONObject jo = (JSONObject) obj;

        spark.udf().register("getJsonVal", new UDF1<String, String>() {
            @Override
            public String call(String key) {
                return  (String) jo.get(key.substring(0, 5));
            }
        }, DataTypes.StringType);

        df = df.withColumn("cluster", functions.callUDF("getJsonVal", df.col("existing col_name")));
        df.show(); // SHOWS NEW CLUSTER COLUMN