public boolean inOld(App$TransactionType...);
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
  16: if_icmpge     40
  19: aload_1       
  20: iload_2       
  21: aaload        
  22: ifnull        34
  25: aload_1       
  26: iload_2       
  27: aaload        
  28: aload_0       
  29: if_acmpne     34
  32: iconst_1      
  33: ireturn       
  34: iinc          2, 1
  37: goto          13
  40: iconst_0      
  41: ireturn