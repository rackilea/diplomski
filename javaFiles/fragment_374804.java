public class ValueText {
   private String text;
   private String value;

   public ValueText(final String text, final String value) {
      this.text = text;
      this.value = value;
   }

   @Override
   public String toString() {
      return text;
   }

   public String getValue() {
      return value;
   }
}