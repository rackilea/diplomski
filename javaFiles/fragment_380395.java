@GET
@Path("/invoices")
public Invoices readInvoices() {
    // ...
}

@GET
@Path("/invoices/{invoice_id: \\d+}")
public Invoice readInvoice(@PathParam("invoice_id") final long invoiceId) {
    // ...
}