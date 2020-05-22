$ javap -private Outer.Inner1
Compiled from "Outer.java"
class Outer$Inner1 extends Outer$InnerBase{
    final Outer this$0;
    private Outer$Inner1(Outer);
}

$ javap -private Outer.InnerBase
Compiled from "Outer.java"
class Outer$InnerBase extends java.lang.Object{
    final Outer this$0;
    private Outer$InnerBase(Outer);
    Outer$InnerBase(Outer, Outer$1);
}