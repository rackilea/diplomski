@XmlRootElement( name="MSG")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLStructure {

   @XmlPath("CASE/Field1/text()")
   private String field1;

   @XmlPath("CASE/Field2/text()")
   private String field2;
}