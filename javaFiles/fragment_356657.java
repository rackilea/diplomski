public void forLoop1();
  Code:
   0:   new     #2; //class java/util/ArrayList
   3:   dup
   4:   invokespecial   #3; //Method java/util/ArrayList."<init>":()V
   7:   astore_1
   8:   iconst_0
   9:   istore_2
   10:  iload_2
   11:  aload_1
   12:  invokeinterface #4,  1; //InterfaceMethod java/util/List.size:()I
   17:  if_icmpge       34
   20:  getstatic       #5; //Field java/lang/System.out:Ljava/io/PrintStream;
   23:  ldc     #6; //String hi
   25:  invokevirtual   #7; //Method java/io/PrintStream.println:(Ljava/lang/Str
ing;)V
   28:  iinc    2, 1
   31:  goto    10
   34:  return

public void forLoop2();
  Code:
   0:   new     #2; //class java/util/ArrayList
   3:   dup
   4:   invokespecial   #3; //Method java/util/ArrayList."<init>":()V
   7:   astore_1
   8:   aload_1
   9:   invokeinterface #4,  1; //InterfaceMethod java/util/List.size:()I
   14:  istore_2
   15:  iconst_0
   16:  istore_3
   17:  iload_3
   18:  iload_2
   19:  if_icmpge       36
   22:  getstatic       #5; //Field java/lang/System.out:Ljava/io/PrintStream;
   25:  ldc     #6; //String hi
   27:  invokevirtual   #7; //Method java/io/PrintStream.println:(Ljava/lang/Str
ing;)V
   30:  iinc    3, 1
   33:  goto    17
   36:  return