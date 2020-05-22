import javax.xml.bind.annotation.XmlSeeAlso;
import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

@XmlDiscriminatorNode("@NAME")
@XmlSeeAlso({UserTable.class, WorkTable.class})
public abstract class Table {

}