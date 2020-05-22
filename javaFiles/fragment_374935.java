public class Synthetic {
   public static void main(String[] args) {
      SyntheticMethodDemo a = new SyntheticMethodDemo();
      SyntheticMethodDemo.NestedClass in = a.new NestedClass();
      a.setNestedField("Hello");
      System.out.println(a.getNestedField());
   } // this is my addition
}

class SyntheticMethodDemo {
   NestedClass nc;

   class NestedClass {
      private String nestedField;

      NestedClass() {
         nc = this;
      }
   }

   public String getNestedField() {
      return nc.nestedField;
   }

   public void setNestedField(String nestedField) {
      nc.nestedField = nestedField;
   }
} // this is the code from the site