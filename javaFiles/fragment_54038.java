Dataset<Row> dataset = spark.read().format("org.apache.spark.sql.cassandra")
            .options(new HashMap<String, String>() {
                {
                    put("keyspace", "mykeyspace");
                    put("table", "mytable");
                }
            }).load();

dataset.show();