OperationResult<SchemaChangeResult> opres = keyspace.createColumnFamily(cf, ImmutableMap.<String, Object> builder()
    .put("comparator", "UTF8Type")
    .put("key_validation_class", "UTF8Type")
    .put("gc_grace_seconds", 60*60*24) // gc grace seconds of one day
    .build()
);