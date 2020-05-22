Compiled from "TestClass1.java"
public class TestClass1 extends java.lang.Object{
static int a;

public TestClass1();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

public static void main(java.lang.String[]);
  Code:
   0:   aconst_null
   1:   astore_1
   2:   getstatic   #2; //Field java/lang/System.out:Ljava/io/PrintStream;
   5:   aload_1
   6:   pop
   7:   getstatic   #3; //Field a:I
   10:  invokevirtual   #4; //Method java/io/PrintStream.println:(I)V
   13:  return

static {};
  Code:
   0:   bipush  10
   2:   putstatic   #3; //Field a:I
   5:   return
}