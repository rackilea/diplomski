public void testStream() throws Exception {

    final int numberOfElements = 50;

    DataStream<Tuple2<String, Integer>> tupleStream = env.fromCollection(getCollectionOfBucketImps(numberOfElements));
    CollectSink.values.clear();
    tupleStream
            .map(new MapFunction<Tuple2<String,Integer>, Tuple2<String,Integer>>() {
                @Override
                public Tuple2<String,Integer> map(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {

                    stringIntegerTuple2.f0 += "- concat something";

                    return stringIntegerTuple2;
                }
            }).setParallelism(8)
            .addSink(new CollectSink()).setParallelism(1);
    env.execute();
    sleep(2000);

    assertEquals(numberOfElements, getCollectionOfBucketImps(numberOfElements).size());
    assertEquals(numberOfElements, CollectSink.values.size());
}