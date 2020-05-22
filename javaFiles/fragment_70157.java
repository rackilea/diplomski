enum Grade {
  P,
  A,
  G;
}

public Grade score ( int tests, int homework ) {
  if ( homework <= 599
          || tests <= 149 ) {
    return Grade.P;
  }
  return Grade.G;
}