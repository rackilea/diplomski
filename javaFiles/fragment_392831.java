public static void main(java.lang.String[]);
  flags: ACC_PUBLIC, ACC_STATIC
  Code:
    stack=2, locals=3, args_size=1
       0: ldc           #2                  // String 0.0327f
       2: invokestatic  #3                  // Method java/lang/Float.parseFloat:(Ljava/lang/String;)F
       5: invokestatic  #4                  // Method java/lang/Float.valueOf:(F)Ljava/lang/Float;
       8: astore_1
       9: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
      12: ldc           #6                  // String hello
      14: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      17: goto          31
      20: astore_2
      21: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
      24: ldc           #6                  // String hello
      26: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      29: aload_2
      30: athrow
      31: return
    Exception table:
       from    to  target type
           0     9    20   any
          20    21    20   any
    LineNumberTable:
      line 10: 0
      line 12: 9
      line 13: 17
      line 12: 20
      line 14: 31
    StackMapTable: number_of_entries = 2
         frame_type = 84 /* same_locals_1_stack_item */
        stack = [ class java/lang/Throwable ]
         frame_type = 10 /* same */