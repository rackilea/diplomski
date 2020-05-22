public int bar();
    descriptor: ()I
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #3                  // String foo
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: bipush        8
        10: ireturn
      LineNumberTable:
        line 6: 0
        line 7: 8

  public int foo();
    descriptor: ()I
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=2, args_size=1
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #3                  // String foo
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: bipush        8
        10: ireturn
      LineNumberTable:
        line 12: 0
        line 13: 8
}