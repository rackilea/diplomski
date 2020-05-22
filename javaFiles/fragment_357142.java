List<User> users = Arrays.asList(/* ... */);

final Map<String, Long> occurencesByFruit = users.stream()
        .map(User::getFruits)
        .flatMap(Arrays::stream)
        .collect(Collectors.groupingBy(f -> f, Collectors.counting()));