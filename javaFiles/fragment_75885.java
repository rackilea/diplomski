final Aggregation aggregation = newAggregation(
        match(Criteria.where("key").is("KEYCODE001")),
        unwind("values", true),
        unwind("values.objects", true),
        match(Criteria.where("values.classId").is("CLASS_01")),
        project().and("values.classId").as("classId").and("values.objects").as("object"),
        group(Fields.from(Fields.field("_id", "classId"))).push("object").as("objects"),
        project().and("_id").as("classId").and("objects").as("objects")
);