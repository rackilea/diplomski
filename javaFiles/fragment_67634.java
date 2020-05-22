List<Invoice> invoices = ....;

Map<List<String>, Boolean> uniqueInvoiceNumbers = new HashMap<>();
for(Invoice i : invoices) {
    List<String> key = Arrays.asList(i.getInvoiceNumber(), i.getVendorCode());
    boolean isNull = i.getVatAmount() == null;
    Boolean existing = uniqueInvoiceNumbers.putIfAbsent(key, isNull);
    if(existing != null && existing != isNull) {
    throw new RuleException("The invoices associated with "
        +  key.get(0) + " and vendor " + key.get(1)
        + " have had their vat amount partially filled."
        + " They should either all be filled in or none at all");
    }
}