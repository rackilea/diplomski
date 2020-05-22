List<String> conflictingComponentsCode = componentWarnings.stream()
    .map(ComponentErrorDetail::getComponentCode)
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) 
    .entrySet()
    .stream()
    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
    .map(Map.Entry::getKey)
    .collect(Collectors.toList());