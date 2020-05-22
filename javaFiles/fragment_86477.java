import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="Root")
class Root {
    private MyElement myElement;

    @XmlPath(".")
    public MyElement getMyElement() { return myElement; }
    public void setMyElement(MyElement myElement) { this.myElement = myElement; }
}