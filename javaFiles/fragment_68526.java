import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "physicianList", propOrder = {
    "physicians"
})
public class PhysicianList {

    @XmlElement(name = "Physician")
    protected List<Physician> physicians;

    public List<Physician> getPhysicians() {
        if (physicians == null) {
            physicians = new ArrayList<Physician>();
        }
        return this.physicians;
    }

}