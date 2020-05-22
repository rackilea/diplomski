import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "VisitorDataList")
public class VisitorDataList {

    private List<Visitor> visitors;

    @XmlElementWrapper(name="VisitorData")
    @XmlElement(name = "AttributeList")
    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

}