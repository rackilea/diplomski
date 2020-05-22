invoices.stream()
    .collect(Collectors.toMap(
        i -> Arrays.asList(i.getInvoiceNumber(), i.getVendorCode()),
        Function.identity(),
        (i1,i2) -> {
            if((i1.getVatAmount() == null) != (i2.getVatAmount() == null)) {
                 throw new RuleException("The invoices associated with "
                    +  i.getInvoiceNumber() + " and vendor " + i.getVendorCode()
                    + " have had their vat amount partially filled."
                    + " They should either all be filled in or none at all");
            }
            return i1;
        }));