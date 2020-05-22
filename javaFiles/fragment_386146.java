Map<TopicAndPartition, Long> map = new HashMap<>();
map.put(new TopicAndPartition("topicname", 0), 1L);

JavaInputDStream<Map.Entry> stream = KafkaUtils.createDirectStream(
        javaContext,
        String.class,
        String.class,
        StringDecoder.class,
        StringDecoder.class,
        Map.Entry.class, // <--- This is the record return type from the transformation.
        kafkaParams,
        map,
        messageAndMetadata -> 
            new AbstractMap.SimpleEntry<>(messageAndMetadata.topic(),
                                          messageAndMetadata.message()));