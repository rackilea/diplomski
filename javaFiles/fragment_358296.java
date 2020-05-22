JavaStreamingContext streamingContext = getSparkStreamingContext();
JavaReceiverInputDStream<String> socketTextStream = streamingContext
        .socketTextStream("localhost", 8080);

socketTextStream.foreachRDD((VoidFunction<JavaRDD<String>>) rdd -> {
    rdd.foreach((VoidFunction<String>) s -> {
        // Save data
    });
});