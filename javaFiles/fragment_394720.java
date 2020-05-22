List<Map<Integer, Integer>> maps;

    Map<Integer, Integer> result = maps.stream()
            .map(Map::entrySet)
            .flatMap(Collection::stream)
            .collect(Collectors.groupingBy(
                    Map.Entry::getKey,
                    Collectors.summingInt(Map.Entry::getValue)));