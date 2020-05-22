package forum7876493;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Root {

    private boolean a;

    @XmlTransient
    public boolean isA() {
        return a;
    }

    @XmlAttribute
    public String getA() {
        if(a) {
            return "yes";
        }
        return "no";
    }

    public void setA(String s) {
        this.a = "yes".equals(s) || "on".equals(s) || "in".equals(s);
    }

}