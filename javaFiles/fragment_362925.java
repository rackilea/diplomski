import java.util.Date;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(value=DateAdapter.class, type=Date.class)
    private Date abc;

    @XmlSchemaType(name="date")
    @XmlJavaTypeAdapter(value=DateAdapter.class, type=Date.class)
    private Date qwe;

}