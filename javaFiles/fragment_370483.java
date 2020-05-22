public int reverseNumber(int n) {
  // step one: we find the factors using integer maths
  int s = n;
  int thousands = s / 1000; // this will be 0 if the number is <1000
  s = s - thousands*1000;
  int hundreds = s / 100;   // this will be 0 if the number is <100
  s = s - hundreds*100;
  int tens = s / 10;        // etc.
  s = s - tens*10;
  int ones = s;

  // then: let's start reversing. single digit?
  if (n<10) return n;

  // two digits?
  if (n<100) {
    return ones*10 + tens;
  }

  // etc.
  if (n<1000) {
    return ones*100 + tens*10 + hundreds;
  }

  if (n<10000) {
    return ones*1000 + tens*100 + hundreds*10 + thousands;
  }

  // if we get here, we have no idea what to do with this number.
  return n;
}