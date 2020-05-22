RecordReader<K,V> reader = inf.createRecordReader(splits.get(i), samplingContext);
  reader.initialize(splits.get(i), samplingContext);
  while (reader.nextKeyValue()) {
    samples.add(ReflectionUtils.copy(job.getConfiguration(),
    reader.getCurrentKey(), null));
  }