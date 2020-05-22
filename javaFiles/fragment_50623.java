public static void main(java.lang.String[]);
    Code:
       0: getstatic     #16                 // Field java/lang/System.out:Ljava/
io/PrintStream;
       3: ldc           #22                 // String %.2f
       5: iconst_1
       6: anewarray     #3                  // class java/lang/Object
       9: dup
      10: iconst_0
      11: ldc2_w        #24                 // double 3.1415d
      14: invokestatic  #26                 // Method java/lang/Double.valueOf:(
D)Ljava/lang/Double;
      17: aastore
      18: invokevirtual #32                 // Method java/io/PrintStream.printf
:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
      21: pop
      22: return
}