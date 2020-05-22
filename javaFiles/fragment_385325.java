List<String> word_used = map.entrySet() 
        .stream() 
        .sorted(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed())
        .map(Map.Entry<String,Integer>::getKey)
        .collect(Collectors.toList());

List<Integer> ints_used = map.entrySet() 
        .stream() 
        .sorted(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed())
        .map(Map.Entry<String,Integer>::getValue)
        .collect(Collectors.toList());