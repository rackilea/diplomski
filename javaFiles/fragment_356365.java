Collection<VatType> values = invoiceList.stream()
        .flatMap(invoices -> invoices.getInvoiceDetails().stream())
        .collect(toMap(InvoiceDetails::getVatGroup, VatType::new, (i1, i2) -> {
            i1.setAmount(i1.getAmount() + i2.getAmount());
            i1.setVatAmount(i1.getVatAmount() + i2.getVatAmount());
            return i1;
        }))
        .values();