import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Root {

    private Child child;

    @XmlJavaTypeAdapter(ChildAdapter.class)
    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

}