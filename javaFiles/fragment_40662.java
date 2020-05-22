import java.util.*;
 import javax.xml.bind.annotation.*;
 import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

 @XmlRootElement
 public class Items {

    private List<String> items = new ArrayList<String>();

    @XmlAnyElement
    @XmlJavaTypeAdapter(StringAdapter.class)
    public List<String> getItems() {
    return items;
    }

  }