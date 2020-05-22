class TestNativeArray3D {
  TestNativeArray3D();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return
    LineNumberTable:
      line 3: 0

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #2                  // String TestNativeArray3D
       2: invokestatic  #3                  // Method java/lang/System.loadLibrary:(Ljava/lang/String;)V
       5: bipush        123
       7: bipush        8
       9: bipush        6
      11: invokestatic  #4                  // Method genTerrain:(III)[[[I
      14: astore_1
      15: return
    LineNumberTable:
      line 7: 0
      line 8: 5
      line 9: 15
}