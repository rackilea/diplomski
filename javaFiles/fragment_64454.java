import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElementWrapper(name = "MyStuffData")
    @XmlElementRefs({
            @XmlElementRef(name = "BField", type = B.class),
            @XmlElementRef(name = "CField", type = C.class),
    })
    private List<A> myStuff;

    public List<A> getMyStuff() {
        return myStuff;
    }

}