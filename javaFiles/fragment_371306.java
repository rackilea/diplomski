Map<String, Double> result = 
        weightedVector.entrySet()
                      .stream()
                      .filter(e -> otherVector.containsKey(e.getKey()))
                      .collect(Collectors.toMap(
                          Map.Entry::getKey,
                          e -> e.getValue() * otherVector.get(e.getKey())));