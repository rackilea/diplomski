package example.bar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import example.foo.Foo;

@XmlAccessorType(XmlAccessType.FIELD)
public class Bar {

    private Foo foo;

}