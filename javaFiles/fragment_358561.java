KTable<String, Long> sum = builder.<String, Long>stream("streams-plaintext-input")
        .groupByKey()
        .aggregate(new Initializer<Long>() {
            @Override
            public Long apply() {
                return Long.MIN_VALUE;
            }
        }, new Aggregator<String, Long, Long>() {
            @Override
            public Long apply(final String key, final Long value,final Long aggregate) {
                return aggregate + value;
            }
        }, Materialized.<String, Long, KeyValueStore<Bytes, byte[]>>as("counts-store"));