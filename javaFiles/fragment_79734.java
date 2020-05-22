Map<String,Double> avarage = 
    incomeList.entrySet()
              .stream()
              .collect(Collectors.toMap(Map.Entry::getKey,
                                        e-> e.getValue()
                                             .stream()
                                             .mapToDouble(Double::doubleValue)
                                             .average()
                                             .getAsDouble()));