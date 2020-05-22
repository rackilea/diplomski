public Map<Integer, DeviceType> filterBy(Predicate<DeviceType> predicate) { 
  Objects.requireNonNull(predicate, "predicate");
  return deviceTypesTable.entrySet().stream()
           .filter(entry ->  predicate.test(entry.getValue())
           .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)); 
}