JavaStreamingContext streamingContext = getSparkStreamingContext();
JavaReceiverInputDStream<String> socketTextStream = streamingContext
        .socketTextStream("localhost", 8080);

socketTextStream.foreachRDD(new VoidFunction<JavaRDD<String>>() {
    @Override
    public void call(JavaRDD<String> rdd) throws Exception {
        rdd.foreach(new VoidFunction<String>() {
            @Override
            public void call(String s) throws Exception {
                // Save data
            }
        });
    }
});