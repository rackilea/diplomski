[stephen@blackbox tmp]$ cat Test.java
public class Test {}
[stephen@blackbox tmp]$ javac Test.java 
[stephen@blackbox tmp]$ javap -c Test
Compiled from "Test.java"
public class Test {
  public Test();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return
}
[stephen@blackbox tmp]$