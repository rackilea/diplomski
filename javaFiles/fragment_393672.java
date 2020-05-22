messageTypes.foreach( msgType => {
    final StreamingFileSink<GenericRecord> sink = StreamingFileSink.forBulkFormat
                    (path, ParquetAvroWriters.forGenericRecord(SchemaUtils.getSchema(msgType)))
                    .withBucketAssigner(new EventTimeBucketAssigner())
                    .build();

            dataStream.filter((FilterFunction<GenericRecord>) genericRecord -> {
                if (genericRecord.get(Constants.EVENT_NAME).toString().equals(msgType)) {
                    return true;
                }
                return false;
            }).addSink(sink).name(msgType+"_sink").setParallelism(parallelism);

}})