@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class abc {
   @XmlElement(name = "emp")
   private List<String> emp;
   @XmlElement(name = "xyz")
   private String xyz;
   // added getters and setters for these fields
}