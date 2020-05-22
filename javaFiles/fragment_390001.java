List<String> outputList = inputMap.keySet().stream()
            .filter(Objects::nonNull)
            .map(key -> key + "=="
                            + inputMap.get(key).stream().sorted(c)
                                        .map(Object::toString)
                                        .collect(Collectors.joining(", ","[","]")))
            .sorted()
            .collect(Collectors.toList());