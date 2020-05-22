@XmlRootElement(name="a")
public class A {

   @XmlElement
   private String b;

   @XmlElement
   private String c;

   @XmlAnyElement
   private List<Element> content;
}