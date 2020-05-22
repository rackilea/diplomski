String res = Arrays.asList(array).stream()
        .collect(Collectors.groupingBy(it -> counter .getAndIncrement() / 3))
        .values().stream()
        .map(val-> val.stream().mapToInt(Integer::intValue).sum())
        .map(String::valueOf)
        .collect(Collectors.joining());
        System.out.println(res);