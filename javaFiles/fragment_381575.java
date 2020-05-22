// Compiled from GenericTest.java (version 1.6 : 50.0, super bit)
public class GenericTest {

  // Method descriptor #6 ()V
  // Stack: 1, Locals: 1
  public GenericTest();
    0  aload_0 [this]
    1  invokespecial java.lang.Object() [8]
    4  return
      Line numbers:
        [pc: 0, line: 4]
      Local variable table:
        [pc: 0, pc: 5] local: this index: 0 type: GenericTest

  // Method descriptor #6 ()V
  // Stack: 2, Locals: 3
  public void generic();
     0  new java.util.ArrayList [16]
     3  dup
     4  invokespecial java.util.ArrayList() [18]
     7  astore_1 [test2]
     8  aload_1 [test2]
     9  sipush 343
    12  invokestatic java.lang.Integer.valueOf(int) : java.lang.Integer [19]
    15  invokeinterface java.util.List.add(java.lang.Object) : boolean [25] [nargs: 2]
    20  pop
    21  aload_1 [test2]
    22  iconst_0
    23  invokeinterface java.util.List.get(int) : java.lang.Object [31] [nargs: 2]
    28  checkcast java.lang.Integer [20]
    31  invokevirtual java.lang.Integer.intValue() : int [35]
    34  istore_2 [x2]
    35  return
      Line numbers:
        [pc: 0, line: 7]
        [pc: 8, line: 8]
        [pc: 21, line: 9]
        [pc: 35, line: 10]
      Local variable table:
        [pc: 0, pc: 36] local: this index: 0 type: GenericTest
        [pc: 8, pc: 36] local: test2 index: 1 type: java.util.List
        [pc: 35, pc: 36] local: x2 index: 2 type: int
      Local variable type table:
        [pc: 8, pc: 36] local: test2 index: 1 type: java.util.List<java.lang.Integer>

  // Method descriptor #6 ()V
  // Stack: 2, Locals: 3
  public void nonGeneric();
     0  new java.util.ArrayList [16]
     3  dup
     4  invokespecial java.util.ArrayList() [18]
     7  astore_1 [test2]
     8  aload_1 [test2]
     9  sipush 343
    12  invokestatic java.lang.Integer.valueOf(int) : java.lang.Integer [19]
    15  invokeinterface java.util.List.add(java.lang.Object) : boolean [25] [nargs: 2]
    20  pop
    21  aload_1 [test2]
    22  iconst_0
    23  invokeinterface java.util.List.get(int) : java.lang.Object [31] [nargs: 2]
    28  checkcast java.lang.Integer [20]
    31  invokevirtual java.lang.Integer.intValue() : int [35]
    34  istore_2 [x2]
    35  return
      Line numbers:
        [pc: 0, line: 13]
        [pc: 8, line: 14]
        [pc: 21, line: 15]
        [pc: 35, line: 16]
      Local variable table:
        [pc: 0, pc: 36] local: this index: 0 type: GenericTest
        [pc: 8, pc: 36] local: test2 index: 1 type: java.util.List
        [pc: 35, pc: 36] local: x2 index: 2 type: int
}