Code:
   0:   ldc     #2; //String string
   2:   astore_3
   3:   getstatic       #3; //Field java/lang/System.out:Ljava/io/PrintStream;
   6:   aload_3
   7:   ldc     #2; //String string
   9:   if_acmpne       16
   12:  iconst_1
   13:  goto    17
   16:  iconst_0
   17:  invokevirtual   #4; //Method java/io/PrintStream.println:(Z)V
   20:  return