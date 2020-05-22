FlinkKafkaConsumer010<Tuple2<String, String>> kafkaConsumer = new FlinkKafkaConsumer010<>(
          topicPattern, new CustomKafkaDeserializationSchema, kafkaConsumerProps);
DataStream<Tuple2<String, String>> input = env.addSource(kafkaConsumer);

input.process(new ProcessFunction<Tuple2<String,String>, String>() {
            @Override
            public void processElement(Tuple2<String, String> value, Context ctx, Collector<String> out) throws Exception {
                String topicName = value.f0;
                // your processing logic here.
                out.collect(value.f1);
            }
        });