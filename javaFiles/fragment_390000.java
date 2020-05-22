List<String> outputList = inputMap.keySet().stream()
            .filter(Objects::nonNull)
            .map(key -> key + "==" 
                            + inputMap.get(key).stream().sorted(c)
                                               .collect(Collectors.toList()))
            .sorted()
            .collect(Collectors.toList());