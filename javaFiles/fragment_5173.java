Compiled from "stringtok2.java"
public class stringtok2 {
  public stringtok2();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return        

  public static void main(java.lang.String[]) throws java.lang.Exception;
    Code:
       0: ldc           #2                  // String ABC
       2: astore_1      
       3: new           #3                  // class java/util/StringTokenizer
       6: dup           
       7: aload_1       
       8: invokevirtual #4                  // Method java/lang/String.toString:()Ljava/lang/String;
      11: ldc           #5                  // String ;
      13: invokespecial #6                  // Method java/util/StringTokenizer."<init>":(Ljava/lang/String;Ljava/lang/String;)V
      16: astore_2      
      17: aload_2       
      18: invokevirtual #7                  // Method java/util/StringTokenizer.hasMoreTokens:()Z
      21: ifne          35
      24: new           #8                  // class java/text/ParseException
      27: dup           
      28: ldc           #9                  // String Some msg
      30: iconst_0      
      31: invokespecial #10                 // Method java/text/ParseException."<init>":(Ljava/lang/String;I)V
      34: athrow        
      35: aload_2       
      36: invokevirtual #11                 // Method java/util/StringTokenizer.nextToken:()Ljava/lang/String;
      39: astore_3      
      40: return        
}