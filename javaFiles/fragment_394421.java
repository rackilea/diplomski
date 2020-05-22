@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "Foos", propOrder = { "foo" })
public class Foos {

    private Map<Foo, Foo> fooMap;

    @XmlElements(value = { @XmlElement })
    public Collection<Foo> getFoo() {
        return getFooMap().values();
    }

    public Map<Foo, Foo> getFooMap() {
        if (fooMap == null) {
            fooMap = new HashMap<Foo, Foo>();
        }
        return this.FooMap;
    }
}