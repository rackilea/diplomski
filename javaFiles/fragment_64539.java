Map<String, List<String>> resultSet = 
      responses.stream()
               .flatMap(e -> Arrays.stream(e.getTypes()).map(a -> new AbstractMap.SimpleEntry<>(a, e.getShortName())))
               .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey,
                        Collectors.mapping(AbstractMap.SimpleEntry::getValue, 
                                            Collectors.toList())));