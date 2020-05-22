@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class StudyTag 
{
   @XmlAttribute(name = "OID")
   String OID;

   @XmlElement(namespace = "http://www.cdisc.org/ns/odm/v1.3")
   MetaDataVersion MetaDataVersion;
}