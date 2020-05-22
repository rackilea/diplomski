@XmlRootElement
public class Parent {
   @XmlElementWrapper(name="children")
   @XmlElement(name="child") 
   List<Child> children;
}