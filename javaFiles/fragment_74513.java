@XmlRootElement(name = "ODM")
@XmlAccessorType(XmlAccessType.FIELD)
public class ODMTag
{
   @XmlElement(name = "Study", namespace = "http://www.cdisc.org/ns/odm/v1.3")
   StudyTag study;
}