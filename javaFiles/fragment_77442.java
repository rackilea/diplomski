AggregationOptions options = newAggregationOptions().allowDiskUse(true).build();

Aggregation agg = newAggregation( //
    group("movieId").push("$userId").as("users_rated"), //
    new AggregationOperation() {

      @Override
      public DBObject toDBObject(AggregationOperationContext context) {
        return new BasicDBObject("$out", "movieUsersRated");
      }
    }).withOptions(options);