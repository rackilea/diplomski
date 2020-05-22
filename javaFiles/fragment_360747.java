private static Map<String, Map<String, Long>> mergeMapsValue2(List<Map<String, Map<String, Long>>> valueList) {
    return valueList.stream()
                    .flatMap(e -> e.entrySet().stream())
                    .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collector.of(
                            HashMap::new,
                            (r, t) -> t.getValue().forEach((k, v) -> r.merge(k, v, Long::sum)),
                            (r1, r2) -> { r2.forEach((k, v) -> r1.merge(k, v, Long::sum)); return r1; }
                        )
                    ));
}