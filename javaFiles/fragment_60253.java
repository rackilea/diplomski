public static long getDegree(String sequence){
  if(sequence.length() == 0) return 0;
  long degree = 0;
  char[] array = sequence.toCharArray();

  long S = 0;
  long U = 0;
  long N = 0;

  for(int i = array.length - 1; i >= 0; i--) {
    char c = array[i];
    S = S + (c == 'S' ? U : 0);
    U = U + (c == 'U' ? N : 0);
    N = N + (c == 'N' ? 1 : 0);
  }
  return S;
}