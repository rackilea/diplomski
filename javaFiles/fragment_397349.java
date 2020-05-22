ColumnFamily<UUID, String> columnFamily = new ColumnFamily< UUID, String>(
    "Merchant",  // Column Family Name    
    StringSerializer.get(), //  Key Serializer
    StringSerializer.get());    //  Column Serializer

EntityManager<Merchant, UUID > entityPersister = new DefaultEntityManager.Builder<Merchant, UUID >()
    .withEntityType(Merchant.class)
    .withKeyspace(keyspace)
    .withColumnFamily(columnFamily)
    .build();