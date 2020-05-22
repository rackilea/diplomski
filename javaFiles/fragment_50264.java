public class example2 extends java.lang.Object{
public example2();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

public static void main(java.lang.String[]);
  Code:
   0:   iconst_0
   1:   istore_2
   2:   iload_2
   3:   bipush  10
   5:   if_icmpge       22
   8:   new     #2; //class java/lang/Object
   11:  dup
   12:  invokespecial   #1; //Method java/lang/Object."<init>":()V
   15:  astore_1
   16:  iinc    2, 1
   19:  goto    2
   22:  return
}