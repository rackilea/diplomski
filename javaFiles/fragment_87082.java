import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class MyAbstract implements Myinterface {
    @XStreamImplicit
    private List<? extends Myinterface> children = new ArrayList<Myinterface>();


    public List<? extends Myinterface> getChildren() {
        return children;
    }
}