Map<String, Map<String, String>> filteredMapForKey = originalMap.entrySet()
        .stream()
        .filter(e -> e.getValue()
                .values()
                .stream()
                .anyMatch(innerMapVal -> innerMapVal.equalsIgnoreCase(channelId)))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));