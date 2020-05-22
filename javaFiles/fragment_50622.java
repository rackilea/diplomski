public static void main(java.lang.String[]);
    Code:
       0: new           #16                 // class java/util/Random
       3: dup
       4: ldc2_w        #18                 // long 100l
       7: invokespecial #20                 // Method java/util/Random."<init>":
(J)V
      10: astore_1
      11: aload_1
      12: invokevirtual #23                 // Method java/util/Random.nextFloat
:()F
      15: ldc           #27                 // float 0.1f
      17: frem
      18: invokestatic  #28                 // Method java/lang/Math.abs:(F)F
      21: fstore_2
      22: return
}