package forum9629948;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class B {

    @XmlAttribute
    @XmlID
    @XmlJavaTypeAdapter(IDAdapter.class)
    private Long id;

}