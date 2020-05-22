<VR> KTable<K, VR> aggregate(final Initializer<VR> initializer,
                             final Aggregator<? super K, ? super V, VR> aggregator);

<VR> KTable<K, VR> aggregate(final Initializer<VR> initializer,
                             final Aggregator<? super K, ? super V, VR> aggregator,
                             final Materialized<K, VR, KeyValueStore<Bytes, byte[]>> materialized);