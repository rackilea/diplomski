public static long getDegree(String sequence){
  if(sequence.length() == 0) return 0;
  long degree = 0;
  char[] array = sequence.toCharArray();

  long[] Sa = new long[array.length];
  long[] Ua = new long[array.length];
  long[] Na = new long[array.length];

  if(array[array.length - 1] == 'N') Na[array.length - 1] = 1;
  else Na[array.length - 1] = 0;
  Ua[array.length - 1] = 0;
  Sa[array.length - 1] = 0;

  for(int i = array.length - 2; i >= 0; i--) {
    char c = array[i];
    Na[i] = Na[i + 1] + (c == 'N' ? 1 : 0);
    Ua[i] = Ua[i + 1] + (c == 'U' ? Na[i + 1] : 0);
    Sa[i] = Sa[i + 1] + (c == 'S' ? Ua[i + 1] : 0);
  }
  return Sa[0];
}