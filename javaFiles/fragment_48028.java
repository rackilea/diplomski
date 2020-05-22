Map<String, Double> average = arrOfMaps.stream()
    .flatMap(map -> map.entrySet().stream())
    .collect(Collectors.groupingBy(Map.Entry::getKey, 
             Collectors.averagingInt(value -> (Integer)(value.getValue()))));

System.out.println(average);  // {A=3.0, B=4.333333333333333}