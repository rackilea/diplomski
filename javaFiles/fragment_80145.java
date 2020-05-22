Map<String, Double> result = list.stream()
            .map(Data::getElements)
            .flatMap((Multimap<String, Integer> map) -> {
                return map.entries().stream();
            })
            .collect(Collectors.groupingBy(Map.Entry::getKey,
                    Collectors.averagingInt((Entry<String, Integer> token) -> {
                        return token.getValue();
                    })));
    System.out.println(result);

    List<Integer> result2 = list.stream()
            .filter((Data data) -> {
                return data.getElements().get("c").stream().anyMatch(i -> i < 4);
            })
            .map(Data::getId)
            .collect(Collectors.toList());
    System.out.println(result2);