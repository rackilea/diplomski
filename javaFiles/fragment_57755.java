simon@lucifer:~$ cat TestClass.java
public class TestClass {
  public static void main(String[] args) {
    int i = 5;
    String strI = "" + i;
  }
}
simon@lucifer:~$ javac TestClass.java && javap -c TestClass
Compiled from "TestClass.java"
public class TestClass extends java.lang.Object{
public TestClass();
  Code:
   0:    aload_0
   1:    invokespecial    #1; //Method java/lang/Object."<init>":()V
   4:    return

public static void main(java.lang.String[]);
  Code:
   0:    iconst_5
   1:    istore_1