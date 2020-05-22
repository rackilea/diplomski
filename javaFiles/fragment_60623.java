public JavaInputDStream<Object> FillDStream() {
    LinkedList<RDD<Object>> rdds = new LinkedList<RDD<Object>>();
    rdds.add(context.sparkContext.emptyRDD());
    rdds.add(context.sparkContext.emptyRDD());

    JavaInputDStream<Object> filledDStream = context.queueStream(rdds);
    return filledStream;
}