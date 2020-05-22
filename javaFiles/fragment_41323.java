public Optional<DeviceType> findFirst(Predicate<DeviceType> predicate) { 
  Objects.requireNonNull(predicate, "predicate");
  return deviceTypesTable.values().stream()
           .filter(predicate)
           .findFirst();
}