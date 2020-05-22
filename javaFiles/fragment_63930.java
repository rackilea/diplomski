package forum11769758;

import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement
public class MyClass {

    private int id;
    private String details;
    private Collection<MyClass> children = new Vector<MyClass>();

    public MyClass() {
    }

    public MyClass(int id, String details) {
        this.id = id;
        this.details = details;
    }

    @XmlElementWrapper
    @XmlElementRef
    @XmlJavaTypeAdapter(MyClassAdapter.class)
    public Collection<MyClass> getChildren() {
        return children;
    }

    public void addChild(MyClass child) {
        children.add(child);
    }

    public String getDetails() {
        return details;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setChildren(Collection<MyClass> children) {
        this.children = children;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setId(int id) {
        this.id = id;
    }

}