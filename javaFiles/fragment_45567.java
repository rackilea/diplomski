package base;

@XmlRootElement(name = "Request")
@XmlAccessorType(XmlAccessType.FIELD)
public class Request {

    @XmlElementRef
    public Foo<?> foo;
}