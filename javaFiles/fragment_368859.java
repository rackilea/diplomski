package testjaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@XmlAccessorType(XmlAccessType.FIELD)
public class Foo
{
    @XmlAttribute
    private String id;

    private String bar;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getBar ()
    {
        return bar;
    }

    public void setBar (String bar)
    {
        this.bar = bar;
    }


}