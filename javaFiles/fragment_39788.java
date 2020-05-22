λ  Desktop  javap -c Outer.Inner
Compiled from "Outer.java"
public class Outer$Inner extends java.lang.Object{
final Outer this$0;

public Outer$Inner(Outer);
  Code:
   0:   aload_0
   1:   aload_1
   2:   putfield    #1; //Field this$0:LOuter;
   5:   aload_0
   6:   invokespecial   #2; //Method java/lang/Object."<init>":()V
   9:   return

public void redo1();
  Code:
   0:   aload_0
   1:   getfield    #1; //Field this$0:LOuter;
   4:   invokevirtual   #3; //Method Outer.print:()V
   7:   return

public void redo2();
  Code:
   0:   aload_0
   1:   getfield    #1; //Field this$0:LOuter;
   4:   invokevirtual   #3; //Method Outer.print:()V
   7:   return

}