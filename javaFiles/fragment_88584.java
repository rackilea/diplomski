import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class MyConfig {

    private List<String> includes;

    @XmlElementWrapper
    @XmlElement(name = "include")
    public List<String> getIncludes() {
        return includes;
    }

    public void setIncludes(List<String> includes) {
        this.includes = includes;
    }

}