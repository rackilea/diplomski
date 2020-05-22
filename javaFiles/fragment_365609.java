import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="P1")
@XmlAccessorType(XmlAccessType.FIELD)
public class P1 {

    @XmlElement(name = "CTS")
    List<CTS> cts;

}