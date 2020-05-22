import java.util.List;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlPath("s:resource/s:information/s:date/text()")
    private String date;

    @XmlPath("s:resource/s:information/s:name/text()")
    private String name;

    @XmlPath("s:resource/s:elements/s:element")
    private List<Element> elements;

}