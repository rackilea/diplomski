package forum7876493;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Root {

    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean a;

    public boolean isA() {
        return a;
    }

    public void setA(String s) {
        this.a = "yes".equals(s) || "on".equals(s) || "in".equals(s);
    }

}