Aggregation agg = newAggregation(
            group("searchTerm")
                    .addToSet("date").as("dateAddToSet"),
            new CustomAggregationOperation(
                new BasicDBObject("$project",
                    new BasicDBObject("_id",0)
                        .append("searchTerm","$_id")
                        .append("percent",new BasicDBObject(
                                "$divide", new Object[]{
                                    new BasicDBObject("$size","dateAddToSet"),
                                    28
                                }

                            )
                        )
                )
            )
    );