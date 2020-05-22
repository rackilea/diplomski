public interface TestInterface {
   public static String NON_CONST_B = "" ; 
}

public class AutoFinal  {    
   public static void main(String args[]) {
      TestInterface.NON_CONST_B = "hello-b" ;
      // ....
   }
}