Optional<Element> buttonOpt = ...
Map<String, Set<String>> stringStringMap =
        buttonOpt.map(button -> 
            button.attributes()
                  .asList()
                  .stream()
                  .flatMap(at -> Arrays.stream(at.getValue().split(" "))
                                       .map(v -> new SimpleEntry<>(at.getKey(),v)))
                  .collect(groupingBy(Map.Entry::getKey, 
                                      mapping(Map.Entry::getValue, toSet()))))
                .orElse(new HashMap<>());