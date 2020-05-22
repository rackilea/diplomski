@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Users 
{
   @XmlElement(name = "xmlUsers")
   List<XmlUser> users = new ArrayList<XmlUser>();
}