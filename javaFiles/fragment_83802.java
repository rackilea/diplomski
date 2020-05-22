@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name = "sub2")
    public JAXBElement<String> createSub2(String value) {
        return new JAXBElement<>(new QName(null, "sub2"),
                                 String.class, Element.class, value);
    }
}