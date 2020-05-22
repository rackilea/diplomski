SparkConf conf = new SparkConf().setAppName("org.sparkexample.WordCount").setMaster("local");
JavaSparkContext context = new JavaSparkContext(conf);
JavaRDD<String> textFile = context.textFile("urlFile");

textFile.foreach (new VoidFunction<String>() {
    public void call (String line) {
        // this code will be executed parallely for each line in file
        ExtractTrainingData ed = new ExtractTrainingData();
        List<Elements> list = ed.getElementList(inputUrl);
        ed.processElementList( inputUrl, list); 
    }
});