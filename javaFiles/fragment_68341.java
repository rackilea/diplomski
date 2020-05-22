public static void main(java.lang.String[]);
    Code:
       0: iconst_2      
       1: tableswitch   { // 1 to 3
                     1: 28
                     2: 39
                     3: 50
               default: 61
          }
      28: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      31: ldc           #3                  // String Happy
      33: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      36: goto          69
      39: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      42: ldc           #5                  // String Birthday
      44: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      47: goto          69
      50: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      53: ldc           #6                  // String To the ground!
      55: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      58: goto          69
      61: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      64: ldc           #7                  // String <3
      66: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      69: return