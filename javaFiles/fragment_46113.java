Aggregation agg = newAggregation(
        match(Criteria.where("_id").in(ids)),
        project().and("nested.field").as("fields")
        unwind("fields"),        
        group("_id").max("fields.version").as("maxVersion")
    );