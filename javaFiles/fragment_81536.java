public static Map<String, Integer> sortByValueThenByKey(Map<String, Integer> unsortMap) {
      return unsortMap.entrySet()
               .stream()
               .sorted(Map.Entry.<String, Integer>comparingByValue()
                       .thenComparingInt(e -> e.getKey().length()))
               .collect(Collectors.toMap(Map.Entry::getKey, 
                     Map.Entry::getValue,(oldValue, newValue) -> newValue, 
                             LinkedHashMap::new));
}