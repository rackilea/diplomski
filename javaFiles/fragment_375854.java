// Method descriptor #15 ([Ljava/lang/String;)V
  // Stack: 7, Locals: 1
  public static void main(java.lang.String[] args);
     0  getstatic java.lang.System.out : java.io.PrintStream [16]
     3  new ca.polymtl.ptidej.generics.java.Util44 [22]
     6  dup
     7  invokespecial ca.polymtl.ptidej.generics.java.Util44() [24]
    10  ldc <String "a"> [25]
    12  ldc <String "b"> [27]
    14  invokevirtual ca.polymtl.ptidej.generics.java.Util44.compare(java.lang.Object, java.lang.Object) : boolean [29]
    17  invokevirtual java.io.PrintStream.println(boolean) : void [33]
    20  getstatic java.lang.System.out : java.io.PrintStream [16]
    23  new ca.polymtl.ptidej.generics.java.Util44 [22]
    26  dup
    27  invokespecial ca.polymtl.ptidej.generics.java.Util44() [24]
    30  new java.lang.String [39]
    33  dup
    34  ldc <String ""> [41]
    36  invokespecial java.lang.String(java.lang.String) [43]
    39  new java.lang.Long [46]
    42  dup
    43  lconst_1
    44  invokespecial java.lang.Long(long) [48]
    47  invokevirtual ca.polymtl.ptidej.generics.java.Util44.compare(java.lang.Object, java.lang.Object) : boolean [29]
    50  invokevirtual java.io.PrintStream.println(boolean) : void [33]
    53  return
      Line numbers:
        [pc: 0, line: 24]
        [pc: 20, line: 25]
        [pc: 53, line: 26]
      Local variable table:
        [pc: 0, pc: 54] local: args index: 0 type: java.lang.String[]