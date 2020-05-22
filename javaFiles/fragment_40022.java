final class ext.Test$Immutable {
  private final int foo;

  private ext.Test$Immutable();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: iconst_0
       6: putfield      #2                  // Field foo:I
       9: return

  private int getFoo();
    Code:
       0: iconst_0
       1: ireturn

  public java.lang.String toString();
    Code:
       0: ldc           #4                  // String (IMMUTABLE:0)
       2: areturn
}