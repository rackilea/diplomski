package forum10795793;

import javax.xml.bind.annotation.*;

public class Field {

    String mappedField;

    @XmlAttribute(name = "mappedField")
    public String getMappedField() {
        return mappedField;
    }

    public void setMappedField(String mappedField) {
        this.mappedField = mappedField;
    }

}