Map<String, List<String>> logHeadersToValue =  Arrays.stream(LogHeaders.values())
    .collect(
        HashMap::new,
        (map, logHeader) -> logHeader.getLogKeyVariations().stream()
            .filter(httpHeaders::containsKey)
            .findAny()
            .ifPresent(x -> map.put(logHeader.key, httpHeaders.get(x))),
        Map::putAll
    );