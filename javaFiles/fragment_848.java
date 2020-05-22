Map<String, Long> countsByType = list.stream()
    .collect(Collectors.groupingBy(DataPoint::getType, Collectors.counting()));


Map<String, Long> countsByPlatform = list.stream()
     .collect(Collectors.groupingBy(DataPoint::getPlatform, Collectors.counting()));