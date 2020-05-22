public void zero();
Code:
   0: iconst_0                          // Push int constant 0
   1: istore_1                          // Store into local variable 1 (sum=0)
   2: iconst_0                          // Push int constant 0
   3: istore_2                          // Store into local variable 2 (i=0)
   4: goto          22                  // First time through don't increment
   7: iload_1
   8: aload_0
   9: getfield      #14                 // Field mArray:[LTest$Foo;
  12: iload_2
  13: aaload
  14: getfield      #39                 // Field Test$Foo.mSplat:I
  17: iadd
  18: istore_1
  19: iinc          2, 1
  22: iload_2                           // Push value of local variable 2 (i)
  23: aload_0                           // Push local variable 0 (this)
  24: getfield      #14                 // Field mArray:[LTest$Foo;
  27: arraylength                       // Get length of array
  28: if_icmplt     7                   // Compare and loop if less than (i < mArray.length)
  31: return

public void one();
Code:
   0: iconst_0                          // Push int constant 0
   1: istore_1                          // Store into local variable 1 (sum=0)
   2: aload_0                           // Push this
   3: getfield      #14                 // Field mArray:[LTest$Foo;
   6: astore_2                          // Store reference into local variable (localArray)
   7: aload_2                           // Load reference from local variable
   8: arraylength                       // Get length of array
   9: istore_3                          // Store into local variable 3 (len = mArray.length)
  10: iconst_0                          // Push int constant 0
  11: istore        4                   // Store into local variable 4 (i=0)
  13: goto          29                  // First time through don't increment
  16: iload_1
  17: aload_2
  18: iload         4
  20: aaload
  21: getfield      #39                 // Field Test$Foo.mSplat:I
  24: iadd
  25: istore_1
  26: iinc          4, 1
  29: iload         4                   // Load i from local variable
  31: iload_3                           // Load len from local variable
  32: if_icmplt     16                  // // Compare and loop if less than (i < len)
  35: return