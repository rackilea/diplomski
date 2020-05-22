import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAnyElement;

public abstract class AbstractCollection<T> {

    protected List<T> collection = new ArrayList<T>();

    @XmlAnyElement(lax=true)
    public List<T> getCollection() {
        return collection;
    }

}