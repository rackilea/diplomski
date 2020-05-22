package forum11153599;

import java.util.Collection;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
class Root {
    @XmlElement
    private String data;

    @XmlPath("details/some_other_element/text()")
    private String someOtherElement;

    @XmlPath("details/collection/element")
    private Collection<Element> elements;

}