protected String toCombinedString(SomeClass shipment) {
    return Optional.ofNullable(shipment)
            .map(SomeClass::getBill)
            .map(bill -> extractAttributes(bill, Bill::getNumberString, Bill::getPrefixString)) // use this further
            .orElse(null);
}

private String extractAttributes(Bill entity, Function<Bill, String>... mappers) {
    List<String> attributes = Arrays.stream(mappers)
            .map(function -> function.apply(entity))
            .collect(Collectors.toList());
    return attributes.stream().anyMatch(s -> s == null || s.isEmpty()) ?
            null : String.join("-", attributes);
}