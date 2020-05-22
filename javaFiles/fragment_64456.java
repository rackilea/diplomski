import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElementWrapper(name = "MyStuffData")
    @XmlElements({
            @XmlElement(name = "B", type = B.class),
            @XmlElement(name = "C", type = C.class),
    })
    private List<A> myStuff;

    public List<A> getMyStuff() {
        return myStuff;
    }

}