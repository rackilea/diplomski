SparkConf conf = new SparkConf();
conf.setAppName("Spark MultipleContest Test");
conf.set("spark.driver.allowMultipleContexts", "true");
conf.setMaster("local");

SparkContext sc = new SparkContext(conf);
SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);

//Create a Java Context which is the same as the scala one under the hood
JavaSparkContext.fromSparkContext(sc)