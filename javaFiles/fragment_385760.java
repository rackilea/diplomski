props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
Producer<Integer, GenericRecord> producer = new KafkaProducer<Integer, GenericRecord>(props);

for (int i = 0; i < 1000; i++) {
    GenericData.Record avroRecord = new GenericData.Record(schema);
    avroRecord.put("str1", "Str 1-" + i);
    avroRecord.put("str2", "Str 2-" + i);
    avroRecord.put("int1", i);

    ProducerRecord<String, GenericRecord> data = new ProducerRecord<String, GenericRecord>("StreamExample_1", new Integer(i), avroRecord);
    producer.send(data);
}

producer.close();