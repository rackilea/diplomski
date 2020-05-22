Compiled from "ImplicitNullChecks.java"
public class bytecodetests.ImplicitNullChecks {
  public bytecodetests.ImplicitNullChecks();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  void createInner(bytecodetests.ImplicitNullChecks);
    Code:
       0: new           #26                 // class bytecodetests/ImplicitNullChecks$Inner
       3: dup
       4: aload_1
       5: dup
       6: invokestatic  #27                 // Method java/util/Objects.requireNonNull:(Ljava/lang/Object;)Ljava/lang/Object;
       9: pop
      10: invokespecial #28                 // Method bytecodetests/ImplicitNullChecks$Inner."<init>":(Lbytecodetests/ImplicitNullChecks;)V
      13: pop
      14: return

  void lambda(java.lang.Object);
    Code:
       0: aload_1
       1: dup
       2: invokestatic  #27                 // Method java/util/Objects.requireNonNull:(Ljava/lang/Object;)Ljava/lang/Object;
       5: pop
       6: invokedynamic #29,  0             // InvokeDynamic #0:get:(Ljava/lang/Object;)Ljava/util/function/Supplier;
      11: astore_2
      12: return
}