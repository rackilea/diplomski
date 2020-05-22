package generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private final static QName _Foo_QNAME = new QName("", "foo");

    public Foo createFoo() {
        return new Foo();
    }

    @XmlElementDecl(namespace = "", name = "foo")
    public JAXBElement<Foo> createFoo(Foo value) {
        return new JAXBElement<Foo>(_Foo_QNAME, Foo.class, null, value);
    }

}