final JavaRDD<ObjectHandler> result = rdd.keyBy(new Function<ObjectHandler, String>() {
    @Override
    public String call(ObjectHandler v1) throws Exception {
        return v1.username;
    }
}).reduceByKey(new Function2<ObjectHandler, ObjectHandler, ObjectHandler>() {
    @Override
    public ObjectHandler call(ObjectHandler v1, ObjectHandler v2) throws Exception {
        return v1; // choosing one "randomly"
    }
}).values();