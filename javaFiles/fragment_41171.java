private Single<Invoice> getInvoiceWithItems() {
    return getInvoice().flatMap(invoice -> getItems(invoice).map(items -> {
        invoice.setItems(items);
        return invoice;
    }));
}