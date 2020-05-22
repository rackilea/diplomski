SparkConf conf = new SparkConf().setMaster("");
JavaSparkContext jsc = new JavaSparkContext(conf);

// read the content of the file using Hadoop format
JavaPairRDD<LongWritable, Text> data = jsc.newAPIHadoopFile(
        "file_path", // input path
        TextInputFormat.class, // used input format class
        LongWritable.class, // class of the value
        Text.class, // class of the value
        new Configuration());    

JavaRDD<String> mapped = data.map(new Function<Tuple2<LongWritable, Text>, String>() {
    @Override
    public String call(Tuple2<LongWritable, Text> tuple) throws Exception {
        // you will get each line from as a tuple (offset, text)    
        long pos = tuple._1().get(); // extract offset
        String line = tuple._2().toString(); // extract text

        return pos + " " + line;
    }
});