package example.xml;

@XmlTransient
public abstract class Xml {

    private Header header;
    private Customer customer;

    @XmlElement(namespace="http://www.example.org/header")
    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    @XmlElement(namespace="http://www.example.org/customer")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}