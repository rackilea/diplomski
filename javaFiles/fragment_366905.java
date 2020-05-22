char[][] cs = new char[n][];
cs[0] = alphabet.toCharArray();
for (int i = 1; i < n; ++i) {
  cs[i] = Arrays.copyOfRange(cs[i-1], 1, n+1);
  cs[i][n-1] = cs[i-1][0];
}