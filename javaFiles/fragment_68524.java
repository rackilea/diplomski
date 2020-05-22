import java.util.ArrayList;
    import java.util.List;
    import javax.xml.bind.annotation.XmlAccessType;
    import javax.xml.bind.annotation.XmlAccessorType;
    import javax.xml.bind.annotation.XmlElement;
    import javax.xml.bind.annotation.XmlType;

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "physicianList", propOrder = {
        "physician"
    })
    public class PhysicianList {

        @XmlElement(name = "Physician")
        protected List<Physician> physician;

        public List<Physician> getPhysician() {
            if (physician == null) {
                physician = new ArrayList<Physician>();
            }
            return this.physician;
        }

    }