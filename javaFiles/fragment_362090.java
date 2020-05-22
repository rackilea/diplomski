final Properties props = new Properties();
...
final StreamsBuilder builder = new StreamsBuilder();
final KStream<String, String> source = builder.stream("MyTopic");
source.mapValues(record -> record + new Date().toString()).to("MyTopicWithTimeStamp", 
    Produced.with(Serdes.String(), Serdes.String()));
...
final KafkaStreams streams = new KafkaStreams(builder.build(), props);
streams.start();