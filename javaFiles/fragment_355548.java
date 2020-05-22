package forum10795793;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "fields")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fields {

    @XmlElement(name = "field")
    List<Field> fields = new ArrayList<Field>();

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

}