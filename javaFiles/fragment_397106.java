class Test {
  static java.util.Random r;

  Test();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":
()V
       4: return

  boolean test();
    Code:
       0: getstatic     #2                  // Field r:Ljava/util/Random;
       3: invokevirtual #3                  // Method java/util/Random.nextBoole
an:()Z
       6: ireturn

  void test1();
    Code:
       0: aload_0
       1: invokevirtual #4                  // Method test:()Z
       4: ifeq          29
       7: aload_0
       8: invokevirtual #4                  // Method test:()Z
      11: ifeq          29
      14: aload_0
      15: invokevirtual #4                  // Method test:()Z
      18: ifeq          29
      21: getstatic     #5                  // Field java/lang/System.out:Ljava/
io/PrintStream;
      24: ldc           #6                  // String 3x yes
      26: invokevirtual #7                  // Method java/io/PrintStream.printl
n:(Ljava/lang/String;)V
      29: return

  void test2();
    Code:
       0: aload_0
       1: invokevirtual #4                  // Method test:()Z
       4: ifeq          29
       7: aload_0
       8: invokevirtual #4                  // Method test:()Z
      11: ifeq          29
      14: aload_0
      15: invokevirtual #4                  // Method test:()Z
      18: ifeq          29
      21: getstatic     #5                  // Field java/lang/System.out:Ljava/
io/PrintStream;
      24: ldc           #6                  // String 3x yes
      26: invokevirtual #7                  // Method java/io/PrintStream.printl
n:(Ljava/lang/String;)V
      29: return

  static {};
    Code:
       0: new           #8                  // class java/util/Random
       3: dup
       4: invokespecial #9                  // Method java/util/Random."<init>":
()V
       7: putstatic     #2                  // Field r:Ljava/util/Random;
      10: return
}