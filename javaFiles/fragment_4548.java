@XmlRootElement
@XmlSeeAlso({Variable.class})
public class Contract{

     @XmlElement(name="Variable")
     @XmlJavaTypeAdapter(YourAdapter.class)
     private Map<String,String> map;

     //Getters and setters
}