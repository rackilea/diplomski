List<Map.Entry<String,Integer>> sortedList = map
        .entrySet() 
        .stream() 
        .sorted(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed())
        .collect(Collectors.toList());

List<String> word_used = sortedList
        .stream()
        .map(Map.Entry<String,Integer>::getKey)
        .collect(Collectors.toList());

List<Integer> ints_used = sortedList
        .stream()
        .map(Map.Entry<String,Integer>::getValue)
        .collect(Collectors.toList());