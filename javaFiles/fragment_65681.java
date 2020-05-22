public boolean posNeg(int a, int b, boolean negative) {
  if (negative && (a < 0 && b < 0)) {
    return true;
  }

  return (a < 0 && b > 0 || a > 0 && b < 0);

} // This is my code that yields unwanted results