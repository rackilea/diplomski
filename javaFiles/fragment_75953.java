int res = int var1 % int var2;  // res as modulo of var1 and var2 (all int, no loss)


long res = int var1 % int var2; /* res as modulo of var1 and var2 (res size is bigger, 
                                * no loss) */

long res = long var1 % int var2; /* res as module of var1 and var2 (the divider is 
                                 * smaller size than dividend and quotient, so no
                                 * problem */