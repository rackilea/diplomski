@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Child.class)
public class Parent {

    public int parentField;

    public Parent(Integer parentField) {
        this.parentField = parentField;
    }
}