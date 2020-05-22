Map<String, Integer> sorted = Server.getMessageCount()
         .entrySet().stream()
         .sorted(Map.Entry.comparingByValue())
         .collect(Collectors.toMap(
                 Map.Entry::getKey, Map.Entry::getValue,
                 (e1, e2) -> e1, LinkedHashMap::new
          ));