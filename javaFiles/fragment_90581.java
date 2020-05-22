public class Invoice {
//member inits
private static int nextInvoiceNumber = 0;
private String companyName;
private double amountDue;
private String chargeDate;
private int invoiceNumber = 0;


//constructor
public Invoice(String _companyName, double _amountDue, String _chargeDate)
{
    invoiceNumber = nextInvoiceNumber;
    nextInvoiceNumber++;
    companyName = _companyName;
    amountDue = _amountDue;
    chargeDate = _chargeDate;

}
....