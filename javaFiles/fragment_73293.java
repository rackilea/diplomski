import javax.xml.namespace.QName;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name="simpleObjJAXBElement")
    public JAXBElement<SimpleObj> createSimpleObj(SimpleObj simpleObj) {
        return new JAXBElement<SimpleObj>(new QName("simpleObjJAXBElement"), SimpleObj.class, simpleObj);
    }

}