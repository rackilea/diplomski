import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "pattern", "prefix", "template", "styleClass" })
@XmlRootElement(name = "support")
public class Support {

    @XmlElement(required = true)
    protected String pattern;
    @XmlElement(required = true)
    protected String prefix;
    protected List<Template> template;
    @XmlElement(name = "style-class")
    protected String styleClass;
    @XmlAttribute
    protected String id;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String value) {
        this.pattern = value;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String value) {
        this.prefix = value;
    }

    public List<Template> getTemplate() {
        if (template == null) {
            template = new ArrayList<Template>();
        }
        return this.template;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String value) {
        this.styleClass = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }
}