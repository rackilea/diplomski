package example.foo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import example.bar.Bar;

@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {

    private Bar bar;

}