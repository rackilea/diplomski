public Test();
  Code:
   0:   aload_0
   1:   invokespecial   #8; //Method java/lang/Object."<init>":()V
   4:   return

public static void main(java.lang.String[]);
  Code:
   0:   ldc #16; //String 5318008
   2:   astore_1
   3:   aload_1
   4:   invokestatic    #18; //Method printClass:(Ljava/lang/Object;)V
   7:   aload_1
   8:   invokestatic    #22; //Method callPrintClass:(Ljava/lang/Object;)V
   11:  iconst_1
   12:  anewarray   #25; //class java/lang/String
   15:  dup
   16:  iconst_0
   17:  aload_1
   18:  aastore
   19:  invokestatic    #27; //Method printClassVarargs:([Ljava/lang/Object;)V
   22:  aload_1
   23:  invokestatic    #31; //Method callPrintClassVarargs:(Ljava/lang/Object;)V
   26:  return

public static void printClass(java.lang.Object);
  Code:
   0:   getstatic   #40; //Field java/lang/System.out:Ljava/io/PrintStream;
   3:   aload_0
   4:   invokevirtual   #46; //Method java/lang/Object.getClass:()Ljava/lang/Class;
   7:   invokevirtual   #50; //Method java/io/PrintStream.println:(Ljava/lang/Object;)V
   10:  return

public static void printClassVarargs(java.lang.Object[]);
  Code:
   0:   getstatic   #40; //Field java/lang/System.out:Ljava/io/PrintStream;
   3:   aload_0
   4:   invokevirtual   #46; //Method java/lang/Object.getClass:()Ljava/lang/Class;
   7:   invokevirtual   #59; //Method java/lang/Class.getComponentType:()Ljava/lang/Class;
   10:  invokevirtual   #50; //Method java/io/PrintStream.println:(Ljava/lang/Object;)V
   13:  return

public static void callPrintClass(java.lang.Object);
  Code:
   0:   aload_0
   1:   invokestatic    #18; //Method printClass:(Ljava/lang/Object;)V
   4:   return

public static void callPrintClassVarargs(java.lang.Object);
  Code:
   0:   iconst_1
   1:   anewarray   #3; //class java/lang/Object
   4:   dup
   5:   iconst_0
   6:   aload_0
   7:   aastore
   8:   invokestatic    #27; //Method printClassVarargs:([Ljava/lang/Object;)V
   11:  return

}