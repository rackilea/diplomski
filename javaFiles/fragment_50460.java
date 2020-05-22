$ javap -c T
Compiled from "T.java"
public class T {
  public T();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return        

  public static void main(java.lang.String[]);
    Code:
       0: iconst_2      
       1: istore_1      
       2: iconst_3      
       3: istore_2      
       4: iload_1       
       5: iload_2       
       6: iadd          
       7: istore_3      
       8: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      11: new           #3                  // class java/lang/StringBuilder
      14: dup           
      15: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      18: ldc           #5                  // String 
      20: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      23: iload_1       
      24: invokevirtual #7                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      27: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      30: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      33: return        
}