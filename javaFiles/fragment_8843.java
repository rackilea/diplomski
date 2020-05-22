static List<Map<String, String>> merge(List<Map<String, String>> left, 
       List<Map<String, String>> right, String joinColumnTableLeft,
       String joinColumnTableRight) {

    Map<String, Map<String, String>> rightById = right.stream()
            .collect(Collectors.toMap(m -> m.get(joinColumnTableRight), 
                                      Function.identity()));

    return left.stream()
               .filter(e -> rightById.containsKey(e.get(joinColumnTableLeft)))
               .map(l -> {
                 Map<String, String> all = new HashMap<>();
                 all.putAll(l);
                 all.putAll(rightById.get(l.get(joinColumnTableLeft)));

                 return all;
               })
               .collect(Collectors.toList());
}