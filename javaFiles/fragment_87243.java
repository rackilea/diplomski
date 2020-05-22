public class Test extends java.lang.Object{
public Test();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

public int f(boolean, boolean, boolean, boolean);
  Code:
   0:   iload_1
   1:   ifeq    19
   4:   iload_2
   5:   ifeq    19
   8:   iload_3
   9:   ifeq    19
   12:  iload   4
   14:  ifeq    19
   17:  iconst_1
   18:  ireturn
   19:  iconst_2
   20:  ireturn

public int g(boolean, boolean, boolean, boolean);
  Code:
   0:   iload_1
   1:   ifeq    19
   4:   iload_2
   5:   ifeq    19
   8:   iload_3
   9:   ifeq    19
   12:  iload   4
   14:  ifeq    19
   17:  iconst_1
   18:  ireturn
   19:  iconst_2
   20:  ireturn

}