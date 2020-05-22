public static void main(java.lang.String...);
    Code:
       0: bipush        10     // push 10 onto stack
       2: istore_1             // store 10 in local variable 1
       3: iload_1              // load local variable 1 (now 10) back to stack
       4: iinc          1, 1   //increment local variable 1 by 1
       7: iload_1              // load local variable 1  (now 11) back to stack
       8: iadd                 // add top 2 variable on stack ( 10 and 11)
       9: istore_1             // store 21 to local variable 1
      10: return
}