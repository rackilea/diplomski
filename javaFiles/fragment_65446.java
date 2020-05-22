import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Home {
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    //setter getter also implemented
}