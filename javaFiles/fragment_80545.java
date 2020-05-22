import org.simpleframework.Attribute;
import org.simpleframework.Text;

public class Item {

    @Attribute
    public String id;

    @Text(data=true)
    public String value;
}