Aggregation agg = Aggregation.newAggregation(VehicleStatus.class, matchStage, sort, new    AggregationOperation() {
  @Override
  public DBObject toDBObject(AggregationOperationContext context) {
    return new BasicDBObject("$out", “outputCollection”);
  }
}).withOptions(Aggregation.newAggregationOptions().allowDiskUse(true).build());