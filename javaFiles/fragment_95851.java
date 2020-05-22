@XmlRootElement
public class YourWrapper {

 String company;

 @XmlElement(name="limitTop",required="false",defaultValue="100")
 int limitTop; 

//getters and setters
}