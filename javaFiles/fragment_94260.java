package forum11449219;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="ipi-list")
public class IPIList {

    private List<String> list = new ArrayList<String>();

    @XmlElement(name="ipi")
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

}