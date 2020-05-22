db.getCollection("dum_stats").find(
    eq("engineNo", "1")
).projection(
    fields(
        include("sensorName"),
        excludeId("_id")
    )
);