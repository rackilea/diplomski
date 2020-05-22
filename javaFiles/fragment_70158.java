public Grade score ( int tests, int homework ) {
  if ( homework <= 599
          || tests <= 149 
          || (homework <= 719 && tests <= 179 )) {
    return Grade.P;
  }
  return Grade.G;
}