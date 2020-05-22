int n = alphabet.length();
char[][] cs = new char[n][n];
for (int i = 0; i < n; ++i) {
  for (int j = 0; j < n; ++j) {
    cs[i][j] = alphabet.charAt((i + j) % n);
  }
}