@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class MetaDataVersion 
{
   @XmlAttribute(name = "OID")
   String OID;

   @XmlAttribute(name = "Name")
   String name;

   /** 
    * all other elements
    */
}