package example.xml.boo;

@XmlRootElement
@XmlType(propOrder = {"header", "customer", "someBooSpecificField"})
public class XmlBoo extends Xml {

    private String someBooSpecificField;

    // getter & setter
}