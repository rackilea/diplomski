private KStream<String, StringAggregator> getAggregator(String topicName, 
                                                        KStream<String, String> input,
                                                        KTable<String, StringAggregator> aggregator) {

    return input
            .leftJoin(aggregator, (inputMessage, aggregatorMessage) -> { 
                if (aggregatorMessage == null) { 
                    aggregatorMessage = new StringAggregator(); 
                }
                aggregatorMessage.add(inputMessage);
                return aggregatorMessage; 
            }).peek((k, v) -> logger.info("Aggregated a join input for {}: {}, {} aggregated.", topicName, k, v.size()));
}