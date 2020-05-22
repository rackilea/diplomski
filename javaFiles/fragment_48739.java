import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement
class Module {
    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(localName = "field")
    @JacksonXmlElementWrapper(useWrapping=false)
    List<Field> field;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<Field> getField() {
        return field;
    }
    public void setField(List<Field> field) {
        this.field = field;
    }
    @Override
    public String toString() {
        return "Module [id=" + id + ", " + field + "]";
    }
}

class Field {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(localName = "title")
    private String title;

    @JacksonXmlProperty(localName = "value")
    @JacksonXmlElementWrapper(useWrapping=false)
    private List<Value> value;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<Value> getValue() {
        return value;
    }
    public void setValue(List<Value> value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Field [id=" + id + ", title=" + title + ", value=" + value
                + "]";
    }
}

class Value{

    @JacksonXmlProperty(isAttribute = true)
    private String checked;

    @JacksonXmlText(value = true)
    private String value;

    public String getChecked() {
        return checked;
    }
    public void setChecked(String checked) {
        this.checked = checked;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Value [checked=" + checked + ", " + value + "]";
    }
}

public class JacksonXmlParser {

    public static void main(String[] args) throws Exception {
        ObjectMapper xmlMapper = new XmlMapper();
        Module obj = xmlMapper.readValue(new File("module.xml"), Module.class);
        System.out.println(obj);
    }

}