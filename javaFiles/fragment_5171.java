Compiled from "stringtok.java"
public class stringtok {
public stringtok();
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
    21: ifeq          32
    24: aload_2       
    25: invokevirtual #8                  // Method java/util/StringTokenizer.nextToken:()Ljava/lang/String;
    28: astore_3      
    29: goto          43
    32: new           #9                  // class java/text/ParseException
    35: dup           
    36: ldc           #10                 // String Some msg
    38: iconst_0      
    39: invokespecial #11                 // Method java/text/ParseException."<init>":(Ljava/lang/String;I)V
    42: athrow        
    43: return