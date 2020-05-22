/* The following were generated with a little C program, not included. */
static const unsigned maxPow10 = 20;
static const unsigned long long pow8[] = {
                     1ULL,                    8ULL,                   64ULL,                  512ULL,                 4096ULL,
                 32768ULL,               262144ULL,              2097152ULL,             16777216ULL,            134217728ULL,
            1073741824ULL,           8589934592ULL,          68719476736ULL,         549755813888ULL,        4398046511104ULL,
        35184372088832ULL,      281474976710656ULL,     2251799813685248ULL,    18014398509481984ULL,   144115188075855872ULL
};
static const unsigned long long pow9[] = {
                     1ULL,                    9ULL,                   81ULL,                  729ULL,                 6561ULL,
                 59049ULL,               531441ULL,              4782969ULL,             43046721ULL,            387420489ULL,
            3486784401ULL,          31381059609ULL,         282429536481ULL,        2541865828329ULL,       22876792454961ULL,
       205891132094649ULL,     1853020188851841ULL,    16677181699666569ULL,   150094635296999121ULL,  1350851717672992089ULL
};  
static const unsigned long long pow10[] = {
                     1ULL,                   10ULL,                  100ULL,                 1000ULL,                10000ULL,
                100000ULL,              1000000ULL,             10000000ULL,            100000000ULL,           1000000000ULL,
           10000000000ULL,         100000000000ULL,        1000000000000ULL,       10000000000000ULL,      100000000000000ULL,
      1000000000000000ULL,    10000000000000000ULL,   100000000000000000ULL,  1000000000000000000ULL, 10000000000000000000ULL
};            

/* Return the number of integers in the range [0, lim % 10**n) which
 * do not have the digit avoid in their decimal representation.
 * (lim % 10**n is the last n digits of lim).
 */
static unsigned long long countWithout(unsigned long long lim, int n, int avoid) {
  unsigned long long count = 0;
  while (n) {
    /* isolate the nth last digit of lim and decrement n */
    unsigned digit = lim / pow10[--n] % 10;
    /* For each starting digit less than digit except avoid,
     * add 9**n qualifying integers. If the avoided digit is
     * encountered, stop.
     */
    count += (digit <= avoid ? digit : digit - 1) * pow9[n];
    if (digit == avoid) break;
  }
  return count;
}

static unsigned long long countTo(unsigned long long lim) {
  unsigned long long count = 0;
  unsigned n = maxPow10;
  /* Loop over the digits in lim until a 6 or an 8 is encountered or all of the
   * digits have been processed. For each digit position, add the appropriate
   * number of qualifying numbers which start with a smaller digit, using either
   * the xor formula 2 * (9**n - 8**n) or the exclusion formula 9**n, depending
   * on whether the starting digit is special or not. Once a special digit is
   * encountered, use countWithout to process the rest of the digits.
   */
  while (n) {
    unsigned digit = lim / pow10[--n] % 10;
    switch (digit) {
      default:count += digit * (2 * (pow9[n] - pow8[n]));
              break;
      case 6: count += 6 * (2 * (pow9[n] - pow8[n]));
              return count + countWithout(lim, n, 8);
      case 7: count += 6 * (2 * (pow9[n] - pow8[n])) + pow9[n];
              break;
      case 8: count += 7 * (2 * (pow9[n] - pow8[n])) + pow9[n];
              return count + countWithout(lim, n, 6);
      case 9: count += 7 * (2 * (pow9[n] - pow8[n])) + 2 * pow9[n];
              break;
    }
  }
  return count;
}

unsigned long long countBetween(unsigned long long lo, unsigned long long hi) {
  return hi > lo ? countTo(hi) - countTo(lo) : 0;
}