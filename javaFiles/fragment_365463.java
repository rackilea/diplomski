import java.util.List;
import javax.xml.bind.annotation.*;    
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="Animals")
@XmlAccessorType(XmlAccessType.FIELD)
public class Animals {


    @XmlPath("Animal[@type='A']")
    private List<AnimalA> listA;

    @XmlPath("Animal[@type='B']")
    private List<AnimalB> listB;

}