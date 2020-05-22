package derived;

@XmlRootElement(name = "Foo", namespace = "urn:foo/Bar")
public class DerivedFoo extends Foo<DerivedBar> {
    // something
}