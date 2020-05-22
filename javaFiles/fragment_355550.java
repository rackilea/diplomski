package forum10795793;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "fields")
public class Fields {

    List<Field> fields = new ArrayList<Field>();

    @XmlElement(name = "field")
    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

}