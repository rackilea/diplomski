static int[] split(String s, int[] a) {
  int n = 0, aIndex = 0;
  for (int sIndex = 0, sLength = s.length(); sIndex < sLength; sIndex++) {
    char c = s.charAt(sIndex);
    if (c == ' ') { // Separator
      a[aIndex++] = n;
      n = 0;
    } else if ('0' <= c && c <= '9') { // Number
      n = n * 10 + (c - '0'); // Add a digit to the current number
    }
  }
  a[aIndex] = n;
  return a;
}