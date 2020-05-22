Aggregation aggregation = newAggregation(
      project("subDepartmentList").and(new AggregationExpression() {
          @Override
          public DBObject toDbObject(AggregationOperationContext context) {
              return new BasicDBObject(
                "$arrayElemAt", Arrays.asList(
                  new BasicDBObject("$filter",
                    new BasicDBObject("input",
                      new BasicDBObject("$map",
                        new BasicDBObject("input","$subDepartmentList")
                          .append("as","sd")
                          .append("in",new BasicDBObject(
                            "$arrayElemAt", Arrays.asList(
                              new BasicDBObject("$filter",
                                new BasicDBObject("input","$$sd.labServiceList")
                                  .append("as","ls")
                                  .append("cond", new BasicDBObject("$eq", Arrays.asList("$$ls._id","123abc")))
                              ),
                              0
                            )
                          ))
                      )
                    )
                    .append("as","sd")
                    .append("$ne", Arrays.asList("$$sd", null))
                  ),
                  0
                )
              );
          }
      }).as("subDepartmentList")
    );