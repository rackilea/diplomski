public static void main(java.lang.String[]);
    Code:
       0: bipush        66
       2: invokestatic  #3                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
       5: astore_1
       6: aload_1
       7: checkcast     #4                  // class java/lang/Integer
      10: invokestatic  #5                  // Method incr:(Ljava/lang/Integer;)V
      13: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
      16: aload_1
      17: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      20: return