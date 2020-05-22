PCollection<String> windowedValues = validMessageStream.apply(Window
            .<String>configure()
            .triggering(Repeatedly.forever(AfterFirst.of(
                    AfterPane.elementCountAtLeast(2000),
                    AfterProcessingTime.pastFirstElementInPane().plusDelayOf(
                            Duration.standardSeconds(windowDurationSeconds)))))
            .discardingFiredPanes());

windowedValues.apply(FileIO.<String, String>writeDynamic()
            .by(Event::getKey)
            .via(TextIO.sink())
            .to("gs://data_pipeline_events_test/events/")
            .withDestinationCoder(StringUtf8Coder.of())
            .withNumShards(1)
            .withNaming(key -> FileIO.Write.defaultNaming(key, ".json")));