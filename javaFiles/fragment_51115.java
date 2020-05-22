List<C1> list = c1List.stream()
                      .collect(toMap(c -> c.id, c -> c.c2Set, (set1, set2) -> Stream.concat(set1.stream(), set2.stream()).collect(toSet())))
                      .entrySet()
                      .stream()
                      .map(e -> new C1(e.getKey(), e.getValue()))
                      .collect(toList());