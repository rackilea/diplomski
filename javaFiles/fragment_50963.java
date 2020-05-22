import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class Parent {

    private String parentProp;

    public String getParentProp() {
        return parentProp;
    }

    public void setParentProp(String parentProp) {
        this.parentProp = parentProp;
    }

}