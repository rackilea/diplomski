@XmlAccessorType(XmlAccessType.FIELD)
public class Tx {

    @XmlElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private SoapEnvelope envelope;
}