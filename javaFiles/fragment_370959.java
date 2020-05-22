@JacksonXmlRootElement(localName = "BESAPI")
public class BESAPI {

    @JacksonXmlProperty(isAttribute = true, localName = "noNamespaceSchemaLocation", namespace = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI)
    private String noNamespaceSchemaLocation;

    @JacksonXmlProperty(isAttribute = false, localName = "Employee")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Employee> employees;

    // public getters and setters (omitted here for brevity)
}