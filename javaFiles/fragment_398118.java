Compiled from "ScopeTest.java"
class ScopeTest extends java.lang.Object{
ScopeTest();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

public void outside(java.lang.String[]);
  Code:
   0:   iconst_0
   1:   invokestatic    #2; //Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
   4:   astore_2
   5:   aload_1
   6:   astore  4
   8:   aload   4
   10:  arraylength
   11:  istore  5
   13:  iconst_0
   14:  istore  6
   16:  iload   6
   18:  iload   5
   20:  if_icmpge       55
   23:  aload   4
   25:  iload   6
   27:  aaload
   28:  astore  7
   30:  aload   7
   32:  invokestatic    #3; //Method java/lang/Integer.valueOf:(Ljava/lang/String;)Ljava/lang/Integer;
   35:  astore_3
   36:  aload_2
   37:  invokevirtual   #4; //Method java/lang/Integer.intValue:()I
   40:  aload_3
   41:  invokevirtual   #4; //Method java/lang/Integer.intValue:()I
   44:  iadd
   45:  invokestatic    #2; //Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
   48:  astore_2
   49:  iinc    6, 1
   52:  goto    16
   55:  return

public void inside(java.lang.String[]);
  Code:
   0:   iconst_0
   1:   invokestatic    #2; //Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
   4:   astore_2
   5:   aload_1
   6:   astore_3
   7:   aload_3
   8:   arraylength
   9:   istore  4
   11:  iconst_0
   12:  istore  5
   14:  iload   5
   16:  iload   4
   18:  if_icmpge       54
   21:  aload_3
   22:  iload   5
   24:  aaload
   25:  astore  6
   27:  aload   6
   29:  invokestatic    #3; //Method java/lang/Integer.valueOf:(Ljava/lang/String;)Ljava/lang/Integer;
   32:  astore  7
   34:  aload_2
   35:  invokevirtual   #4; //Method java/lang/Integer.intValue:()I
   38:  aload   7
   40:  invokevirtual   #4; //Method java/lang/Integer.intValue:()I
   43:  iadd
   44:  invokestatic    #2; //Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
   47:  astore_2
   48:  iinc    5, 1
   51:  goto    14
   54:  return

}