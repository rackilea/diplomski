StructType schema = new StructType()
  .add("_n", StringType, true)
  .add("_p", StringType, true)
  .add("_t", TimestampType, true)
  .add("account", StringType, true)
  .add("channel", StringType, true)
  .add("device_type", StringType, true);