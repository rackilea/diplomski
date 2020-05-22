import java.math.BigInteger;
public class ObjectFactory {
    // element instance factories
    JAXBElement<LetterBody> createLetterBody(LetterBody value);
    JAXBElement<String>     createLetterBodyName(String value);
    JAXBElement<BigInteger> createLetterBodyQuantity(BigInteger value);
    JAXBElement<String>     createLetterBodyProductName(String value);
  // type instance factory
    LetterBody> createLetterBody();
}

public class LetterBody {
    // Mixed content can contain instances of Element classes
    // Name, Quantity and ProductName. Text data is represented as
    // java.util.String for text.
    @XmlMixed 
    @XmlElementRefs({
            @XmlElementRef(name="productName", type=JAXBElement.class),
            @XmlElementRef(name="quantity", type=JAXBElement.class),
            @XmlElementRef(name="name", type=JAXBElement.class)})
    List getContent(){...}
}