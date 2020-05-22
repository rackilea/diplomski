Set<ProcessedData> processedData = map.entrySet().stream()
    .map(e -> new ProcessedData(
        entry.getKey(), 
        entry.getValue(),
        (float) entry.getValue() * 100.0 / (float) sourceData.size()))
    .collect(Collectors.toSet());