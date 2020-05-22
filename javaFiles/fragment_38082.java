KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList(topic));

        consumer.poll(Duration.ofSeconds(10));

        consumer.assignment().forEach(System.out::println);

        AtomicLong maxTimestamp = new AtomicLong();
        AtomicReference<ConsumerRecord<String, String>> latestRecord = new AtomicReference<>();

        // get the last offsets for each partition
        consumer.endOffsets(consumer.assignment()).forEach((topicPartition, offset) -> {
            System.out.println("offset: "+offset);

            // seek to the last offset of each partition
            consumer.seek(topicPartition, (offset==0) ? offset:offset - 1);

            // poll to get the last record in each partition
            consumer.poll(Duration.ofSeconds(10)).forEach(record -> {

                // the latest record in the 'topic' is the one with the highest timestamp
                if (record.timestamp() > maxTimestamp.get()) {
                    maxTimestamp.set(record.timestamp());
                    latestRecord.set(record);
                }
            });
        });
        System.out.println(latestRecord.get());