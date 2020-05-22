package testjaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root
{
    private Foo foo;


    public Foo getFoo ()
    {
        return foo;
    }

    public void setFoo (Foo foo)
    {
        this.foo = foo;
    }


}