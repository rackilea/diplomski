import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Span {
    List<Div> div;
    List<String> mixed;

    @XmlMixed
    public List<String> getMixed() {
        return mixed;
    }

    public void setMixed(List<String> mixed) {
        this.mixed = mixed;
    }

    public List<Div> getDiv() {
        return div;
    }

    @XmlElement
    public void setDiv(List<Div> div) {
        for (int i = 0; i < div.size(); i++) {
            System.out.print("element");
        }
        this.div = div;
    }
}