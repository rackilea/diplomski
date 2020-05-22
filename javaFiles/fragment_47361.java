public class A {
   private String attributeName;

   public String getAttributeName() {
       return attributeName;
   }

   public void method(){
        ...

        try {
            //code is written here.
            attributeName = lAttribute.getName(); 
        }
        catch() { 
        } 
   } 
}