SparkConf conf = new SparkConf().setAppName("org.sparkexample.WordCount").setMaster("local");
JavaSparkContext context = new JavaSparkContext(conf);
JavaRDD<String> textFile = context.textFile("urlFile");

textFile.map (new Function<String, List<Elements>() {
    public List<Elements> call (String line) {
        // this code will be executed parallely for each line in file
        ExtractTrainingData ed = new ExtractTrainingData();
        List<Elements> list = ed.getElementList(inputUrl);
        return list;
    }
}).flatMap (list -> list.iterator())
.foreach ((String element) -> { 
    // here put code that is in processElementList
 });