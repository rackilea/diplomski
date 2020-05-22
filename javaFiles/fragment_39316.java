String brokers = "localhost:2181";
    String group="spark";   

    Map<String, Integer> topicMap = new HashMap<String,Integer>();
            topicMap.put("twitter-topic",1);
    JavaStreamingContext jssc = new JavaStreamingContext("local[4]", "SparkStream", new  Duration(1200));
      JavaPairReceiverInputDStream<String, String> messages = KafkaUtils.createStream(jssc, brokers, group, topicMap);

    JavaDStream<String> data = messages.map(new Function<Tuple2<String, String>, String>() 
                                                    {
                                                        public String call(Tuple2<String, String> message)
                                                        {
                                                            return message._2();
                                                        }

                                                    });
            data.foreachRDD(new Function<JavaRDD<String>, Void>() {
                Mongo mongo = new Mongo("localhost", 27017);
                DB db = mongo.getDB("mongodb");

                DBCollection collection = db.getCollection("fb");

                public Void call(JavaRDD<String> data) throws Exception {
                    // TODO Auto-generated method stub
                    if(data!=null){
                        List<String>result=data.collect();

                        for (String temp :result) {

                            System.out.println(temp);

                            DBObject dbObject = (DBObject) JSON.parse(temp.toString());

                            collection.insert(dbObject);

                        }
                        System.out.println("Inserted Data Done");

                    }else {
                        System.out.println("Got no data in this window");
                    }

                    return null;
                } 

            });
    jssc.start();
    jssc.awaitTermination();
}