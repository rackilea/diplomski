KStream<String, String> source = builder.stream(stringSerde, stringSerde, "in-stream");
source.foreach(new ForeachAction<String, String>() {
    void apply(String key, String value) {
        System.out.println(key + ": " + value);
    }
 });