public class javatesting.JavaTesting extends java.lang.Object{
public javatesting.JavaTesting();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

public static void main(java.lang.String[]);
  Code:
   0:   ldc     #2; //String 1;2;3
   2:   astore_1
   3:   aload_1
   4:   ldc     #3; //String ;
   6:   invokevirtual   #4; //Method java/lang/String.split:(Ljava/lang/String;)
[Ljava/lang/String;
   9:   astore_2
   10:  aload_2
   11:  arraylength
   12:  istore_3
   13:  iconst_0
   14:  istore  4
   16:  iload   4
   18:  iload_3
   19:  if_icmpge       37
   22:  aload_2
   23:  iload   4
   25:  aaload
   26:  astore  5
   28:  aconst_null
   29:  astore  5
   31:  iinc    4, 1
   34:  goto    16
   37:  return

}