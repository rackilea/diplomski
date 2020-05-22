public class MyClass {
   // variable below declared *in* the class
   // and is visible throughout the class
   private String testString = "";
   private String anotherVariable; // declared but not instantiated


public void onWindowFocusChanged(boolean hasFocus){
    if (hasFocus){
        // don't redeclare the variable here, and don't use new String(...)
        // final String teststring= new String ("blubblub"); 

        anotherVariable = "blubblub"; // instantiated here
    }
}


   public void someMethod() {
      // variable is now visible inside of all non-static methods
      System.out.println(testString);
   }

}