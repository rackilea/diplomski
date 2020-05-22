import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="IMPORT")
@XmlAccessorType(XmlAccessType.FIELD)
public class Import {

    @XmlElement(name="TABLE")
    private List<Table> tables;

}