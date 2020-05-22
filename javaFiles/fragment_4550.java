@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Variable.class})
public class Contract{

     @XmlPath("./Variable[@Name='id']/Value")
     private Long id;

     @XmlPath("./Variable[@Name='templateName']/Value")
     private String templateName;

     @XmlPath("./Variable[@Name='isComplete']/Value")
     private boolean isComplete;

     @XmlElement(name="Variable")
     @XmlJavaTypeAdapter(YourAdapter.class)
     private Map<String,String> map;

     //Getters and setters
}