Map<Integer,TreeSet<Long>> capacities = 
  gasType.entrySet()
         .stream ()
         .collect(Collectors.groupingBy (e -> Integer.parseInt(e.getValue().substring(0,e.getValue ().indexOf("-"))),
                                         TreeMap::new,
                                         Collectors.mapping (Map.Entry::getKey,
                                                             Collectors.toCollection(TreeSet::new))));