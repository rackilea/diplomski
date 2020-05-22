Map<String, Double> map = new HashMap<>();
      map.put("a1", 6.75);
      map.put("a2", 9.0);
      map.put("a3", 6.8);

      map = map.entrySet().stream()
      .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
      .collect(Collectors.toMap(
         Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

//Iterate through the map