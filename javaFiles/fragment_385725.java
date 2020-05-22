Map<Integer,Set<Long>> capacities = 
  gasType.entrySet()
         .stream ()
         .collect(Collectors.groupingBy (e -> Integer.parseInt(e.getValue().substring(0,e.getValue ().indexOf("-"))),
                                         Collectors.mapping (Map.Entry::getKey,
                                                             Collectors.toSet())));