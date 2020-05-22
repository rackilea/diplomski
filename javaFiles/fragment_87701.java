....
static void foo();
Code:
   0: iconst_2
   1: iconst_2
   2: multianewarray #2,  2             // class "[[I"
   6: astore_0
   7: aload_0
   8: iconst_1
   9: aaload
  10: iconst_1
  11: bipush        123
  13: iastore
  14: return