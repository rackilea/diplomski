personMap.entrySet()
         .stream()
         .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()
                                                            .stream()
                                                            .mapToInt(Person::getAge)
                                                            .average()
                                                            .orElse(-1)));