import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "styleClass", "template", "support" })
@XmlRootElement(name = "user-agent")
public class UserAgent {

    @XmlElement(name = "style-class", required = true)
    protected String styleClass;
    @XmlElement(required = true)
    protected List<Template> template;
    @XmlElement(required = true)
    protected List<Support> support;

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String value) {
        this.styleClass = value;
    }

    public List<Template> getTemplate() {
        if (template == null) {
            template = new ArrayList<Template>();
        }
        return this.template;
    }

    public List<Support> getSupport() {
        if (support == null) {
            support = new ArrayList<Support>();
        }
        return this.support;
    }

}