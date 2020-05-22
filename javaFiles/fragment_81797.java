// Snippet 1                        // Snippet 2
int i;                              int i;
double temp;                        for (i = 0; i < 5; i++) {     
for (i = 0; i < 5; i++) {               double temp = i;
    temp = i;                       }
}

// Generates                        // Generates

   0: iconst_0                       0: iconst_0
   1: istore_1                       1: istore_1
   2: iload_1                        2: iload_1
   3: iconst_5                       3: iconst_5
   4: if_icmpge     16               4: if_icmpge     16
   7: iload_1                        7: iload_1
   8: i2d                            8: i2d
   9: dstore_2                       9: dstore_2
  10: iinc          1, 1             10: iinc          1, 1
  13: goto          2                13: goto          2