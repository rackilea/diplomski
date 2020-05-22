import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
@XmlType(propOrder={"someValue", "fields"})
@XmlAccessorType(XmlAccessType.FIELD)
class Test {

    @XmlJavaTypeAdapter(SomeValueAdapter.class)
    @XmlPath("fields[1]")
    boolean someValue;

    @XmlJavaTypeAdapter(FieldsAdapter.class)
    List<Field> fields = new ArrayList<Field>();

    public Boolean isSomeValue() {
        return someValue;
    }

    public void setSomeValue(boolean someValue) {
        this.someValue = someValue;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        for(Field field : fields) {
            if("someValue".equals(field.getName())) {
                someValue = Boolean.valueOf(field.getValue());
                fields.remove(field);
            }
        }
    }

}