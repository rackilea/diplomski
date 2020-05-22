list.stream()
    .map(l -> Stream.concat(
            l.subList(0, l.size() - 1).stream().map(i -> i - 2),
            Stream.of(l.get(l.size() - 1))).collect(Collectors.toList())
    )
    .collect(Collectors.toList());