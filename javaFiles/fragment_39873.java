public class snippet.Snippet {
  public snippet.Snippet();
    Code:
       0: aload_0       
       1: invokespecial #8                  // Method java/lang/Object."<init>":()V
       4: return        

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #16                 // Method java/lang/System.currentTimeMillis:()J
       3: lstore_1      
       4: iconst_0      
       5: istore_3      
       6: goto          16
       9: invokestatic  #22                 // Method DoubleCalcTest:()D
      12: pop2          
      13: iinc          3, 1
      16: iload_3       
      17: ldc           #26                 // int 100000000
      19: if_icmplt     9
      22: invokestatic  #16                 // Method java/lang/System.currentTimeMillis:()J
      25: lstore_3      
      26: getstatic     #27                 // Field java/lang/System.out:Ljava/io/PrintStream;
      29: new           #31                 // class java/lang/StringBuilder
      32: dup           
      33: ldc           #33                 // String That took 
      35: invokespecial #35                 // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
      38: lload_3       
      39: lload_1       
      40: lsub          
      41: invokevirtual #38                 // Method java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
      44: ldc           #42                 // String  milliseconds
      46: invokevirtual #44                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      49: invokevirtual #47                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      52: invokevirtual #51                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      55: return        

  public static double DoubleCalcTest();
    Code:
       0: ldc2_w        #64                 // double 987.654321d
       3: dstore_0      
       4: ldc2_w        #66                 // double 123.456789d
       7: dstore_2      
       8: dload_0       
       9: dload_2       
      10: dadd          
      11: dstore_0      
      12: dload_0       
      13: dload_2       
      14: dsub          
      15: dstore_0      
      16: dload_0       
      17: dload_2       
      18: dmul          
      19: dstore_0      
      20: dload_0       
      21: dload_2       
      22: ddiv          
      23: dreturn       
}