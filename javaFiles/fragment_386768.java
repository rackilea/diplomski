intVar = 0xFF & bb[0];
  //intVar = 00000002    
  intVar <<= 8;
  //intVar = 00000200
  intVar |= 0xFF & bb[1];
  // intVar = 000002F7