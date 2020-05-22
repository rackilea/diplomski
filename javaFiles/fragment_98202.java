public static void main(java.lang.String[]);
    Code:
       0: ldc           #16                 // String something
       2: astore_1      
       3: ldc           #18                 // String something_else
       5: astore_2      
       6: ldc           #16                 // String something
       8: ldc           #18                 // String something_else
      10: invokevirtual #20                 // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      13: ifeq          27
      16: getstatic     #26                 // Field java/lang/System.out:Ljava/io/PrintStream;
      19: ldc           #32                 // String yes
      21: invokevirtual #34                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      24: goto          35
      27: getstatic     #26                 // Field java/lang/System.out:Ljava/io/PrintStream;
      30: ldc           #40                 // String no
      32: invokevirtual #34                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      35: return