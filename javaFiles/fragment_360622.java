public ComputerMicrobe reverse() {
  int i;
  int n;
  String c = "";

  n = dNACode.length();

  for (i = n - 1; i >= 0; i--){
    c = c + dNACode.charAt(i);
  }

  dNACode = c;
  return this;
}