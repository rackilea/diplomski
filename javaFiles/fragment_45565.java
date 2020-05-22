package base;

@XmlAccessorType(XmlAccessType.FIELD)
public class Foo<T extends Bar> {

    @XmlElementRef
    public List<T> bar;

}