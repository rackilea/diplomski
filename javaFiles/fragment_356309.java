import java.util.List;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlPath("resource/information/date/text()")
    private String date;

    @XmlPath("resource/information/name/text()")
    private String name;

    @XmlPath("resource/elements/element")
    private List<Element> elements;

}