Supplier<Map<String, Map<Long, Long>>> mapSupplier = () -> {
    Map<String, Map<Long, Long>> outputMap = new HashMap<>();
    outputMap.put("firstId", new HashMap<>());
    outputMap.put("secondId", new HashMap<>());
    return outputMap;
};

Map<String, Map<Long, Long>> reduce = objects.stream().collect(mapSupplier,
        (acc, obj) -> {
            acc.get("firstId").merge(obj.firstId, 1L, (curv, incr) -> curv + incr);
            acc.get("secondId").merge(obj.secondId, 1L, (curv, incr) -> curv + incr);
        }
        , (acc1, acc2) -> {
            acc2.get("firstId").forEach((k, v) -> acc1.get("firstId").merge(k, v, (v1, v2) -> v1 + v2));
            acc2.get("secondId").forEach((k, v) -> acc1.get("secondId").merge(k, v, (v1, v2) -> v1 + v2));
        });