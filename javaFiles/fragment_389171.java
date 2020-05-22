package forum9799081;

import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "alpha")
public class MyBean {
    private String thetaValue;

    @XmlPath("beta/theta/text()")
    public String getThetaValue() {
        return this.thetaValue;
    }

    public void setThetaValue(String thetaValue) {
        this.thetaValue = thetaValue;
    }

}