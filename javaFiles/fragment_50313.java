@XmlAccessorType(XmlAccessType.FIELD)
public class Input 
{
   @XmlAttribute
   private String type;
   @XmlAttribute
   private String name;
   @XmlValue
   private String value;

   public Input() {}

   public Input(String type, String name, String value) 
   {
      this.type = type;
      this.name = name;
      this.value = value;
   }
}