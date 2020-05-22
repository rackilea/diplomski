KStream<Long, byte[]> streamed = builder.stream(topicName, Consumed.with(longSerde, byteSerde));
 KTable<Long, byte[]> records = streamed.groupByKey().reduce(
            new Reducer<byte[]>() {
                @Override
                public byte[] apply(byte[] aggValue, byte[] newValue) {
                    return newValue;
                }
            }, 
            Materialized.as(storename).with(longSerde,byteSerde));