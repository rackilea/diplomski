// Method descriptor #15 (I)V
  // Stack: 2, Locals: 2
  public void A(int i);
     0  iload_1 [i]
     1  bipush 10
     3  if_icmple 14
     6  getstatic java.lang.System.out : java.io.PrintStream [16]
     9  ldc <String "i"> [22]
    11  invokevirtual java.io.PrintStream.println(java.lang.String) : void [24]
    14  return
      Line numbers:
        [pc: 0, line: 5]
        [pc: 6, line: 6]
        [pc: 14, line: 8]
      Local variable table:
        [pc: 0, pc: 15] local: this index: 0 type: program.TestClass
        [pc: 0, pc: 15] local: i index: 1 type: int
      Stack map table: number of frames 1
        [pc: 14, same]

  // Method descriptor #15 (I)V
  // Stack: 2, Locals: 2
  public void B(int i);
     0  iload_1 [i]
     1  bipush 10
     3  if_icmple 14
     6  getstatic java.lang.System.out : java.io.PrintStream [16]
     9  ldc <String "i"> [22]
    11  invokevirtual java.io.PrintStream.println(java.lang.String) : void [24]
    14  return
      Line numbers:
        [pc: 0, line: 11]
        [pc: 6, line: 12]
        [pc: 14, line: 13]
      Local variable table:
        [pc: 0, pc: 15] local: this index: 0 type: program.TestClass
        [pc: 0, pc: 15] local: i index: 1 type: int
      Stack map table: number of frames 1
        [pc: 14, same]