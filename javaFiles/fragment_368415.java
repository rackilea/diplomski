ConcurrentMap<String, LinkedList<String>> map = new ConcurrentHashMap<>();

ConcurrentMap<String, LinkedList<String>> result = 
    map.entrySet()
       .stream()
       .filter(e -> e.getValue().size() > 4)
       .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));