Kafka
                .outboundChannelAdapter(producerFactory)
                .sync(true)
                .messageKey(m -> m
                        .getHeaders()
                        .get(IntegrationMessageHeaderAccessor.SEQUENCE_NUMBER))
                .headerMapper(mapper())
                .partitionId(m -> 0)
                .topicExpression("headers[kafka_topic] ?: '" + topic + "'")
                .configureKafkaTemplate(t -> t.id("kafkaTemplate:" + topic))
                .get();