return input.getInputParams()
        .entrySet()
        .stream()
        .filter(params -> params.getKey().startsWith("accepted")) // small change
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (a, b) -> b, TreeMap::new));