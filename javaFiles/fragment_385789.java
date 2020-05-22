21: aload_2
  22: iload_3
  23: iinc          3, 1
  26: iload_1
  27: irem
  28: aload_2
  29: iload_3
  30: iinc          3, 1
  33: iload_1
  34: irem
  35: aaload
  36: iload_3
  37: invokedynamic #5,  0 // makeConcatWithConstants:(Ljava/lang/String;I)Ljava/lang/String;
  42: aastore