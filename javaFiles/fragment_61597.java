Compiled from "TestQualified.java"
public class TestQualified extends java.lang.Object{
public TestQualified();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

private void someMethod();
  Code:
   0:   return

public void otherMethod();
  Code:
   0:   aload_0
   1:   invokespecial   #2; //Method someMethod:()V
   4:   aload_0
   5:   invokespecial   #2; //Method someMethod:()V
   8:   return

}