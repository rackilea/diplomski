Aggregation aggregation = newAggregation(
    group("postId"),
    skip(1),
    limit(1)
);

System.out.println(aggregation)