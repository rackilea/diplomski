class Bar implements Foo<java.lang.String> {
  Bar();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void set(java.lang.String);
    Code:
       0: return

  public void set(java.lang.Object);
    Code:
       0: aload_0
       1: aload_1
       2: checkcast     #2                  // class java/lang/String
       5: invokevirtual #3                  // Method set:(Ljava/lang/String;)V
       8: return
}