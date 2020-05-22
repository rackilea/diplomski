package forum11537931;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Relations {

    @XmlAttribute(name="target-type")
    String targetType;

    @XmlElement(name="relation")
    List<Relation> relations = new ArrayList<Relation>();

}