List<String> strings = 
      Optional.of(special)
              .filter(e -> !e.isEmpty())
              .map(l -> l.stream().map(s -> createNewVal(s))
                                  .collect(Collectors.toList()))
              .orElseGet((() -> Collections.singletonList(myString)));