SparkConf conf = new SparkConf().setAppName("Test random").setMaster("local");
    JavaSparkContext jsc = new JavaSparkContext(conf);

    int numRows= 10;//put here how many rows you want
    JavaRDD<String> randomStringRDD = RandomRDDs.uniformJavaRDD(jsc, rows).map((Double d) -> RandomStringUtils.randomAlphabetic(42));

    //display (to use only on small dataset)
    for(String row:randomStringRDD.collect()){
        System.out.println(numRows);
    }