@JacksonXmlRootElement(localName = "MyContact")
public class Contact {
   @JacksonXmlProperty(localName = "firstName")
   private String name;

   @JacksonXmlProperty(isAttribute = true)
   private String attr;

   public String getAttr() {
       return attr;
   }

   public void setAttr(String attr) {
      this.attr = attr;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }