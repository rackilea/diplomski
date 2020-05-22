import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class C {

    private List<A> as = new ArrayList<A>();

    @XmlElement(name="a")
    public List<A> getAs() {
        return as;
    }

}