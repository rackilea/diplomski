Aggregation aggregation = newAggregation(
            match(
                    Criteria.where("userId").in(Arrays.asList(1, 2))
                            .and("status").is(1)
            ),

            group("itemId").count().as("count"),

            match(Criteria.where("count").gt(1))

    );