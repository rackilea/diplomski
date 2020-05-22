List<Obj2> lst2 = list.stream()
                      .collect(Collectors.groupingBy(Obj::getSomething))
                      .entrySet()
                      .stream()
                      .map(e -> new Obj2(e.getKey(), e.getValue()))
                      .collect(Collectors.toList());