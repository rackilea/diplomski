Compiled from "Main.java"
public class Main {
  private static final java.lang.String HELLO;

  private static final java.lang.String WORLD;

  public Main();
    Code:
       0: aload_0
       1: invokespecial #1     // Method java/lang/Object."<init>":()V
       4: return

  private static void goodMethod();
    Code:
       0: getstatic     #2     // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #4     // String hello
       5: invokevirtual #5     // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: getstatic     #2     // Field java/lang/System.out:Ljava/io/PrintStream;
      11: ldc           #6     // String world
      13: invokevirtual #5     // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      16: return

  private static void badMethod();
    Code:
       0: getstatic     #2     // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #4     // String hello
       5: invokevirtual #5     // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: getstatic     #2     // Field java/lang/System.out:Ljava/io/PrintStream;
      11: ldc           #6     // String world
      13: invokevirtual #5     // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      16: return
}