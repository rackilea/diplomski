Map<Double, Integer> result2 = list.stream()
    .collect(Collectors.groupingBy(Function.identity())) // this makes {3.2=[3.2], 9.5=[9.5], 4.9=[4.9, 4.9]}
    .entrySet().stream()
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        e -> e.getValue().size())
    );