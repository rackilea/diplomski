import javax.xml.bind.annotation.XmlAnyElement;

public class Body {

    private Object value;

    @XmlAnyElement(lax=true)
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}