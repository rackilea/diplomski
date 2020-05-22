private GlobalKTable<String, theDataList> globalStream() {

   // KStream of records from data-in topic using String and theDataSerde deserializers
  KStream<String, Data> trashStream = getBuilder().stream("data_in", Consumed.with(Serdes.String(), SerDes.theDataSerde));

  thrashStream.to("new_data_in"); // by sending to an other topic you're forcing a repartition on that topic

  KStream<String, Data> newTrashStream = getBuilder().stream("new_data_in", Consumed.with(Serdes.String(), SerDes.theDataSerde));

  // Apply an aggregation operation on the original KStream records using an intermediate representation of a KStream (KGroupedStream)
  KGroupedStream<String, Data> KGS = newTrashStream.groupByKey();

  Materialized<String, theDataList, KeyValueStore<Bytes, byte[]>> materialized = Materialized.as("agg-stream-store");
  materialized = materialized.withValueSerde(SerDes.theDataDataListSerde);

// Return a KTable
  KGS.aggregate(() -> new theDataList(), (key, value, aggregate) -> {
      if (!value.getValideData())
          aggregate.getList().removeIf((t) -> t.getTimestamp() <= value.getTimestamp());
      else
        aggregate.getList().add(value);
      return aggregate;
  }, materialized)
  .to("agg_data_in");

  return getBuilder().globalTable("agg_data_in");
}