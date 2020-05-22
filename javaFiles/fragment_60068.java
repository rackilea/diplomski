@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MyRequest", namespace="http://your.namespace.com")
public class MyRequest implements Serializable
{
   @XmlElement(name = "username", required = true)
   protected String username;
   @XmlElement(name = "password", required = true)
   protected String password;
   @XmlElement(name = "newParam", required = false)
   protected String newParam;
   ...
}