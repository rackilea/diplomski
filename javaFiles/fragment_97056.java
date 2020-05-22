import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "feed")
@XmlAccessorType(XmlAccessType.FIELD)
  public class Feed {

    @XmlElement(name = "entry")
    private List<Entry> entries;

    public List<Entry> getEntries() {
        return this.entries;
    }

}