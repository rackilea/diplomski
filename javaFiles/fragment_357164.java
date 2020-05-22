import java.util.List;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

@XmlDiscriminatorValue("USER")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserTable extends Table {

    @XmlElement(name="ROW")
    private List<UserRow> rows;

}