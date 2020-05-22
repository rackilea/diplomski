Compiled from "Frobincate.java"
public class Frobincate {
  public Frobincate();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return        

  public static void frobincate();
    Code:
       0: sipush        1000
       3: newarray       int
       5: astore_0      
       6: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       9: ldc           #3                  // String bored
      11: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      14: return        
}