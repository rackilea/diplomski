Optional<List<String>> o = uniqueInvoiceNumbers.entrySet()
    .filter(e -> e.getValue().size() > 1)
    .filter(e -> {
        boolean isNull = e.getValue().get(0).getVatAmount() == null;
        return e.getValue().stream().map(Invoice::getVatAmount)
            .anyMatch(isNull? Objects::nonNull: Objects::isNull);
        })
    .map(Map.Entry::getKey)
    .findAny();

if(o.isPresent()) { // can't use ifPresent with checked exception
    List<String> key = o.get();
    throw new RuleException("The invoices associated with "
        +  key.get(0) + " and vendor " + key.get(1)
        + " have had their vat amount partially filled."
        + " They should either all be filled in or none at all");
}