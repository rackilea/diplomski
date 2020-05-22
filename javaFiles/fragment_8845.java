static List<Map<String, String>> merge(List<Map<String, String>> left, 
        List<Map<String, String>> right,
        String joinColumnTableLeft, String joinColumnTableRight) {

    Map<String, List<Map<String, String>>> rightById = right.stream()
            .collect(Collectors.groupingBy(m -> m.get(joinColumnTableRight)));

    return left.stream()
            .filter(e -> rightById.containsKey(e.get(joinColumnTableLeft)))
            .flatMap(l -> rightById.get(l.get(joinColumnTableLeft)).stream()
                    .map(r -> {
                                Map<String, String> all = new HashMap<>();
                                all.putAll(l);
                                all.putAll(r);

                                return all;
                            }
                    )
    ).collect(Collectors.toList());
}