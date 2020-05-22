Map<String, Double> kvs =
    Arrays.asList("a:1.0", "b:2.0", "c:3.0")
        .stream()
        .map(elem -> elem.split(":"))
        .filter(elem -> elem.length==2)
        .collect(Collectors.toMap(e -> e[0], e -> Double.parseDouble(e[1]));