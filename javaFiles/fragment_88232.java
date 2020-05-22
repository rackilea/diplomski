@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class MyObject{

 @XmlAttribute // Maps to an XML attribute
 private String name;


 private String age; // Maps to an XML element
 ...getters/setters...
}