rdd.flatMap(new FlatMapFunction<ArrayList<Record>, Record>() {
  @Override
  public Iterable<Record> call(ArrayList<Record> records) {
    return records;
  }
});