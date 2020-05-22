@XmlRootElement
public class Invoices {

    public List<Invoice> getInvoices() {
        if (invoices == null) {
            invoices = new ArrayList<Invoice>();
        }
        return invoices;
    }

    @XmlElement(name = "invoice", nillable = true)
    private List<Invoice> invoices; 
}