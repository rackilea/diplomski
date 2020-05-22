List<StatusResponse> responseList = data.entries().stream()
  .map(entry -> {
    Map<Status, Integer> summary = entry.getValue().entries().stream()
      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b));

    return StatusResponse.builder()
      .processedDate(entry.getKey())
      .summary(summary)
      .build();
  }).collect(Collectors.toList());