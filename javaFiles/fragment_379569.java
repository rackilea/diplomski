public class MyClass {

  public static byte[] someMethod() {
    byte[] someByte =null;
       try {
        ...
        someByte = .... ;
    } catch (Exception e) {
        e.printStackTrace();
    } 
    return someByte;
   }    
}