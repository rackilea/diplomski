private static Map<String, Map<String, Long>> mergeMapsValue(List<Map<String, Map<String, Long>>> valueList) {
    return valueList.stream()
                    .flatMap(e -> e.entrySet().stream())
                    .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(
                            e -> e.getValue().entrySet().stream(),
                            Collectors.<Map.Entry<String,Long>,String,Long>toMap(Map.Entry::getKey, Map.Entry::getValue, Long::sum)
                        )
                    ));
}