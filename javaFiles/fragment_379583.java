package forum6907225;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "test")
public class TestClass
{
    @XmlPath("items/item/@type")
    @XmlElement
    private ArrayList<String> itemList = new ArrayList<String>();

  // getters, setters omitted
}