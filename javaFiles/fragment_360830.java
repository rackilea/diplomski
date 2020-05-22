import javax.xml.bind.annotation.*;

@XmlRootElement
public class Foo {

    private Object bar;

    @XmlElement(type=String)
    public Object getBar() {
        return bar;
    }

    public void setBar(Object bar) {
        this.bar = bar;
    }

}