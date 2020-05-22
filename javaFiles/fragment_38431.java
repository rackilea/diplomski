Aggregation aggregation = newAggregation(                               
    match(Criteria.where("isActive")
        .is(1).and("user.userId").in(feedUsers)),
    group("postId")
        .last("postId").as("postId")
        .last("postFor").as("postFor")
        .last("actionType").as("actionType")
        .last("isActive").as("isActive")
        .last("user").as("user")
        .last("createdDate").as("createdDate")
        .last("updatedDate").as("updatedDate"),
    sort(Sort.Direction.DESC, "createdDate"),
    skip( skip ),
    limit( limit )
);