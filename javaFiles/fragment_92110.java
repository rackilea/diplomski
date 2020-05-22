int invoice = details.nextInt();
boolean invoiceRange = ((invoice >= 1000) && (invoice <= 8000));
while (!invoiceRange)
{
    invoice = details.nextInt();
    // Need this line to update the value of invoiceRange every
    // time a new invoice value is read in
    invoiceRange = ((invoice >= 1000) && (invoice <= 8000));
}