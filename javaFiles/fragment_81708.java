final String bootstrapServers = args.length > 0 ? args[0] : "localhost:9092";
final Properties streamsConfiguration = new Properties();
streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-lambda-example"); 
streamsConfiguration.put(StreamsConfig.CLIENT_ID_CONFIG, "wordcount-lambda-example-client");
streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
streamsConfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // add if you want to reset the offset to earliest for each run
final Serde<String> stringSerde = Serdes.String();
final Serde<Long> longSerde = Serdes.Long();
final StreamsBuilder builder = new StreamsBuilder();
final KStream<String, String> textLines = builder.stream("wordcount-input");
final Pattern pattern = Pattern.compile("\\W+", Pattern.UNICODE_CHARACTER_CLASS);
final KTable<String, Long> wordCounts = textLines
  .flatMapValues(value -> Arrays.asList(pattern.split(value.toLowerCase())))
  .groupBy((key, word) -> word)
  .count();
// Write the `KTable<String, Long>` to the output topic.
wordCounts.toStream().to("wordcount-output", Produced.with(stringSerde, longSerde));
final KafkaStreams streams = new KafkaStreams(builder.build(), streamsConfiguration);

streams.cleanUp();
streams.start();