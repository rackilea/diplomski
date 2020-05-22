import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.NONE)
public class MyClass {
    @XmlElement
    private String a = "x";
    @XmlElement
    private String b = "xx";

    @XmlElement
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean c = true;

    public boolean getC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }
}