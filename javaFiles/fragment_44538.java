public abstract class Qux implements Baz {
  public void x();
    Code:
       0: aload_0       
       1: invokestatic  #17            // Method Baz$class.x:(LBaz;)V
       4: return        

  public java.lang.Object x();
    Code:
       0: aload_0       
       1: invokevirtual #22            // Method x:()V
       4: getstatic     #28            // Field scala/runtime/BoxedUnit.UNIT:Lscala/runtime/BoxedUnit;
       7: areturn