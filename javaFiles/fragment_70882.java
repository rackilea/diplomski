Aggregation aggregation = newAggregation(
      new CustomAggregationOperation(
        new BasicDBObject(
          "$redact",
          new BasicDBObject("$cond",
            new BasicDBObject()
              .append("if", new BasicDBObject(
                      "$eq", Arrays.asList("$_id", "$path")
              ))
              .append("then", "$$KEEP")
              .append("else", "$$PRUNE")
          )
        )
      )
    );

    AggregationResults<Metadata> results = ops.aggregate(
            (TypedAggregation<Metadata>) aggregation, Metadata.class);