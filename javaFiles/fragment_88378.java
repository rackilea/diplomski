public boolean in(App$TransactionType...);
Code:
   0: aload_1       
   1: ifnull        9
   4: aload_1       
   5: arraylength   
   6: ifne          11
   9: iconst_0      
  10: ireturn       
  11: iconst_0      
  12: istore_2      
  13: iload_2       
  14: aload_1       
  15: arraylength   
  16: if_icmpge     34
  19: aload_1       
  20: iload_2       
  21: aaload        
  22: aload_0       
  23: if_acmpne     28
  26: iconst_1      
  27: ireturn       
  28: iinc          2, 1
  31: goto          13
  34: iconst_0      
  35: ireturn