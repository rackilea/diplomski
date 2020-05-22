@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {

  @XmlElement(name = "bar")  
  private String bar;

}

@XmlRootElement(name = "doc")
@XmlAccessorType(XmlAccessType.FIELD)
public class Doc {

  @XmlElement(name = "foo")  
  private Foo foo;

}