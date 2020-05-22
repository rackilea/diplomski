Aggregation agg = newAggregation(
        match(Criteria.where("entityid").is(entityId)),
        unwind("value"),
        match(Criteria.where("value.Dockey").in(dockeyList)),
        group("_id").push("value").as("value")
    );