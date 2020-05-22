C:\JavaTools>javap -c IntArrays.class
Compiled from "IntArrays.java"
public class IntArrays {
  public IntArrays();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":
()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class java/util/ArrayList
       3: dup
       4: invokespecial #3                  // Method java/util/ArrayList."<init
>":()V
       7: astore_1
       8: aload_1
       9: iconst_2
      10: newarray       int  <<< Create the first array
      12: dup
      13: iconst_0
      14: iconst_1
      15: iastore
      16: dup
      17: iconst_1
      18: iconst_2
      19: iastore
      20: invokeinterface #4,  2            // InterfaceMethod java/util/List.ad
d:(Ljava/lang/Object;)Z
      25: pop
      26: aload_1
      27: iconst_4
      28: newarray       int  <<< Create the second array
      30: dup
      31: iconst_0
      32: iconst_1
      33: iastore
      34: dup
      35: iconst_1
      36: iconst_2
      37: iastore
      38: dup
      39: iconst_2
      40: iconst_3
      41: iastore
      42: dup
      43: iconst_3
      44: iconst_4
      45: iastore
      46: invokeinterface #4,  2            // InterfaceMethod java/util/List.ad
d:(Ljava/lang/Object;)Z
      51: pop
      52: invokestatic  #5                  // Method java/lang/Math.random:()D
      55: d2i
      56: bipush        10
      58: imul
      59: istore_2
      60: iload_2
      61: newarray       int  <<< Create the 3rd array
      63: astore_3
      64: aload_1
      65: aload_3
      66: invokeinterface #4,  2            // InterfaceMethod java/util/List.ad
d:(Ljava/lang/Object;)Z
      71: pop
      72: return
}