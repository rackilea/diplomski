Optional<Integer> firstValue = h.entrySet().stream()
      .filter(e -> e.getKey().equals(1))
      .flatMap(e -> e.getValue().entrySet().stream())
      .filter(e -> e.getKey().equals("firstKey"))
      .map(e -> e.getValue())
      .findFirst();

firstValue.ifPresent(System.out::println);