C:\>javap -c Switch
Compiled from "Switch.java"
class Switch extends java.lang.Object{
Switch();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

void x(int);
  Code:
   0:   iload_1
   1:   lookupswitch{ //2
                1: 28;
                9: 39;
                default: 50 }
   28:  getstatic       #2; //Field java/lang/System.out:Ljava/io/PrintStream;
   31:  ldc     #3; //String one
   33:  invokevirtual   #4; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   36:  goto    58
   39:  getstatic       #2; //Field java/lang/System.out:Ljava/io/PrintStream;
   42:  ldc     #5; //String nine
   44:  invokevirtual   #4; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   47:  goto    58
   50:  getstatic       #2; //Field java/lang/System.out:Ljava/io/PrintStream;
   53:  ldc     #6; //String nothing
   55:  invokevirtual   #4; //Method java/io/PrintStream.println:(Ljava/lang/String;)V
   58:  return

}