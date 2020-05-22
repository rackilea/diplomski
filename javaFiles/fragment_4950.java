@XmlRootElement(name="notifications")
public class Notification   {
    @XmlTransient
    public String ccNUm;
    @XmlTransient
    public String subMsg;
    @XmlAnyElement
    public List<Element> el  = Lists.newArrayList();

    public void afterUnmarshal(Unmarshaller u , Object parent) {
        for (Element e: el) {
            if ("sub_msg".equalsIgnoreCase(e.getTagName())){
                subMsg = e.getTextContent();
                Node creditCardNumberElement = e.getFirstChild().getNextSibling();
                if ("creditcard_no".equalsIgnoreCase(creditCardNumberElement.getNodeName()))
                    ccNUm = creditCardNumberElement.getTextContent(); 
            }
        } 
    }
}