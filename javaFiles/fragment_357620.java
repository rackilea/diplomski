static List<Integer> getIdFromIsbn(String isbn, Map<Integer, Map<String, Integer>> map) {
    return map.entrySet()                           // Set<Entry<Integer,Map<String,Integer>>>
            .stream()                               // Stream<Entry<Integer,Map<String,Integer>>>
            .flatMap(entry -> entry.getValue().entrySet() // Set<Entry<String,Integer>>
                    .stream()                             // Stream<Entry<String,Integer>>
                    .map(Map.Entry::getKey)               // Stream<String> 
                    .filter(isbn::equals)                 // Stream<String> 
                    .map(subEntry -> entry.getKey()))     // Stream<Integer>
            .collect(Collectors.toList());                // List<Integer>
}