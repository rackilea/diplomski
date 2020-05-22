Properties props = new Properties();
props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

AdminClient adminClient = KafkaAdminClient.create(props);

CreateTopicsResult res = adminClient.createTopics(
        Stream.of("foo", "bar", "baz").map(
                name -> new NewTopic("my-topic-name", 3, (short) 1)
        ).collect(Collectors.toList())
);

res.all().get();