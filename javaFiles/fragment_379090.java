private HashMap<String, HashSet<Integer>> process(HashMap<Integer, List<String>> input) {
     return input.entrySet().stream()
             .flatMap(entry -> entry.getValue().stream().map(s -> new SimpleEntry<>(entry.getKey(), s)))
             .collect(Collectors.groupingBy(SimpleEntry::getValue, HashMap::new,
                 Collectors.mapping(SimpleEntry::getKey, Collectors.toCollection(HashSet::new))));
     }