package forum11537931;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Work {

    @XmlElement(name="relation-list")
    List<Relations> relations;

}