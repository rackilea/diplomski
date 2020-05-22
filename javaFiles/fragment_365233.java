/Invoices             // all invoices
/Invoices?after=2011  // a filter on all invoices

/Invoices/52          // by 52
/Invoices/52/Items    // all items on invoice 52
/Invoices/52/Items/1  // Item 1 from invoice 52

/Companies/{company}/Invoices?sort=Date
/Companies/{company}/Invoices/{invoiceNo} // assuming that the invoice only unq by company?