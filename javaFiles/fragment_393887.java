@XmlRootElement(name = "foo")
@XmlAccessorType(XmlAccessType.NONE)
public class Foo {
  @XmlElement(name="bar")
  public Collection getElements() {
    List elements = new ArrayList();
    elements.add(new Bar);
    elements.add(new Bar);
    return elements;
  }
}