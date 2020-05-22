Map<String,List<String>> output =
    values.entrySet()
          .stream()
          .collect(Collectors.groupingBy(Map.Entry::getValue,
                                         Collectors.mapping(Map.Entry::getKey,
                                                            Collectors.toList())));
System.out.println (output);