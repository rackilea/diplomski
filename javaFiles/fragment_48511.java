0: ldc           #2                  // String hello
     2: astore_1
     3: ldc           #3                  // String goodbye
     5: astore_2
     6: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
     9: aload_1
    10: aload_2
    11: dup
    12: astore_1
    13: invokevirtual #5                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
    16: invokevirtual #6                  // Method java/io/PrintStream.println:(Z)V
    19: return