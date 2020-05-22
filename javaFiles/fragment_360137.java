public class Annotation {

    private List<Recipient> recipients;

    @XmlElementWrapper(name="recipients")
    @XmlElement(name="recipient")
    public List<Recipient> getRecipients() {
        return recipients;
    }
}