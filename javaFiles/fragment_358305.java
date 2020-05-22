Producer<String, String> producer = new KafkaProducer<String, String>(props, new StringSerializer(), new StringSerializer());
 for(int i = 0; i < 10; i++) {
   Future<RecordMetadata> f = producer.send(new ProducerRecord<String, String>(topicName, Integer.toString(i), Integer.toString(i)));
   System.out.println(f.get()); // don't do that in your Production, here just for debugging purpose.
 }
 producer.close();