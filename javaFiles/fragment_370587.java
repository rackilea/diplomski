public class Bean {

   private String value;

   @XmlElement(name="element")
   public void setA(String value) {
      this.value = value;
   }

   @XmlElement(name="element2")
   public void setB(String value) {
      this.value = value;
   }
}