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
   11:  astore_3
   12:  aload_3
   13:  arraylength
   14:  istore  4
   16:  iconst_0
   17:  istore  5
   19:  iload   5
   21:  iload   4
   23:  if_icmpge       41
   26:  aload_3
   27:  iload   5
   29:  aaload
   30:  astore  6
   32:  aconst_null
   33:  astore  6
   35:  iinc    5, 1
   38:  goto    19
   41:  return

}