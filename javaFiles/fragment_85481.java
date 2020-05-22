Compiled from "ImplicitNullChecks.java"
public class bytecodetests.ImplicitNullChecks {
  public bytecodetests.ImplicitNullChecks();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  void createInner(bytecodetests.ImplicitNullChecks);
    Code:
       0: new           #23                 // class bytecodetests/ImplicitNullChecks$Inner
       3: dup
       4: aload_1
       5: dup
       6: invokevirtual #24                 // Method java/lang/Object.getClass:()Ljava/lang/Class;
       9: pop
      10: invokespecial #25                 // Method bytecodetests/ImplicitNullChecks$Inner."<init>":(Lbytecodetests/ImplicitNullChecks;)V
      13: pop
      14: return

  void lambda(java.lang.Object);
    Code:
       0: aload_1
       1: dup
       2: invokevirtual #24                 // Method java/lang/Object.getClass:()Ljava/lang/Class;
       5: pop
       6: invokedynamic #26,  0             // InvokeDynamic #0:get:(Ljava/lang/Object;)Ljava/util/function/Supplier;
      11: astore_2
      12: return
}