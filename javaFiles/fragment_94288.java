public int getGCD(int a, int b) {
 // implementation for two numbers goes here
}

public int getGCD(int[] a) {
  // the GCD of a number with itself is... itself
  int gcd = a[0];

  // compute incrementally
  for( int i=1; i<a.length; i++ ) {
    gcd = getGCD( gcd, a[i] );
  }

  // return result
  return gcd;    
}