StreamsBuilder builder = new StreamsBuilder();
KStream<String, Order> orderStream = builder.stream("orders");
KTable<String,ArrayList<Order>> orderTable = orderStream
      .groupBy((key,value)-> value .get("customerId"))
      .aggregate(()-> new ArrayList<Order>(),
                 (key,val,agg)-> agg.add(val),
                  Materialized.as("customer-orders")
                  .withValueSerde(ArrayListSerde())          
       );