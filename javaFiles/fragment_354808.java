Map<Double, Integer> result = list.stream()
        .distinct()
        .collect(Collectors.toMap(
            Function.identity(),
            v -> Collections.frequency(list, v))
        );