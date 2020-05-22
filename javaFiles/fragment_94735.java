AggregationOperation project = new AggregationOperation() {
       @Override
       public DBObject toDBObject(AggregationOperationContext aggregationOperationContext) {
          return new BasicDBObject("$project", new BasicDBObject("budgetCode", 1).append("taskCode", Arrays.asList("$taskCode")));
    } 
};