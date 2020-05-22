// Clearly this could be extended to encodings of more than one long
  static boolean enoughBitsInCommon(long x, long y) {
      int numHobbiesX = Long.bitCount(x);
      int hobbiesInCommon = Long.bitCount(x & y);
      // used 128 in the hope that compiler will optimise!
      return ((hobbiesInCommon * 128) / numHobbiesX ) > MATCH_THRESHOLD;
  }