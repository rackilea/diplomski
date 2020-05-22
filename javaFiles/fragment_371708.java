public static void main(java.lang.String[]);
   Code:
      0: ldc2_w         #2          // double 0.5d
      3: dstore_1
      4: ldc2_w         #4          // double 3.1415926535d
      7: dstore_3
      8: dload_1
      9: ldc2_w         #6          // double 2.0d
      12: invokestatic  #8         // Method java/lang/Math.pow:(DD)D
      15: dload_3
      16: dmul
      17: dstore        5
      19: dload         5
      21: dstore        7
      23: return