Code:
   0:   ldc     #2; //String str
   2:   astore_1
   3:   ldc     #3; //String ing
   5:   astore_2
   6:   new     #4; //class java/lang/StringBuilder
   9:   dup
   10:  invokespecial   #5; //Method java/lang/StringBuilder."<init>":()V
   13:  aload_1
   14:  invokevirtual   #6; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   17:  aload_2
   18:  invokevirtual   #6; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   21:  invokevirtual   #7; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   24:  astore_3
   25:  getstatic       #8; //Field java/lang/System.out:Ljava/io/PrintStream;
   28:  aload_3
   29:  ldc     #9; //String string
   31:  if_acmpne       38
   34:  iconst_1
   35:  goto    39
   38:  iconst_0
   39:  invokevirtual   #10; //Method java/io/PrintStream.println:(Z)V
   42:  return