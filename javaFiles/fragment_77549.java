public void function(int);
    Code:
       0: iconst_0      
       1: istore_2      
       2: iload_2       
       3: iload_1       
       4: if_icmpge     21
       7: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      10: ldc           #3                  // String Hello.
      12: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      15: iinc          2, 1
      18: goto          2
      21: return        

  public void function(int, int);
    Code:
       0: iconst_0      
       1: istore_3      
       2: iload_3       
       3: iload_1       
       4: iload_2       
       5: iadd          
       6: if_icmpge     23
       9: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      12: ldc           #3                  // String Hello.
      14: invokevirtual #4                  // Method java/io/PrintStream.println(Ljava/lang/String;)V
      17: iinc          3, 1
      20: goto          2
      23: return