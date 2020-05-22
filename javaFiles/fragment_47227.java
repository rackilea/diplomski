final StreamExecutionEnvironment env = 
 StreamExecutionEnvironment.getExecutionEnvironment();
 Properties prop = new Properties();
 prop.setProperty("bootstrap.servers", 
 "10.32.0.2:9092,10.32.0.3:9092,10.32.0.4:9092");
 prop.setProperty("group.id", "test");
    FlinkKafkaConsumer<String> myConsumer= new FlinkKafkaConsumer<> 
  ("flinkTopic", new SimpleStringSchema(),prop);
    myConsumer.setStartFromEarliest();
    DataStream<String> stream = env.addSource(myConsumer);
    stream.print();
    env.execute("Flink Streaming Java API Skeleton");