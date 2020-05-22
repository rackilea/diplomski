socketTextStream.foreachRDD(new Function<JavaRDD<String>, Void>() {
    @Override
    public Void call(JavaRDD<String> rdd) throws Exception {
        rdd.foreach(new VoidFunction<String>() {
            @Override
            public void call(String s) throws Exception {
                // Save data
            }
        });
        return null;
    }
});