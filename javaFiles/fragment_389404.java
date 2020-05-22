long x,y;
  ...
  int numMatches = Long.bitCount(x & y);

  ... becomes

  BitSet x,y;
  ...
  int numMatches = x.and(y).cardinality();