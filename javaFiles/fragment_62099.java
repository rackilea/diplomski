SparkSession spark = SparkSession
    .builder()
    .appName("Java Spark Hive Example")
    .master("local[*]")
    .config("spark.sql.warehouse.dir", warehouseLocation)
    .enableHiveSupport()
    .getOrCreate();

spark.sql("select count(*) from health").show();