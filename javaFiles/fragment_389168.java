package forum9799081;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "alpha")
public class MyBean {
    private String thetaValue;

    @XmlElement(name="beta")
    @XmlJavaTypeAdapter(ThetaValueAdapter.class)
    public String getThetaValue() {
        return this.thetaValue;
    }

    public void setThetaValue(String thetaValue) {
        this.thetaValue = thetaValue;
    }

}