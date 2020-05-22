try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
  int[] counts = split(reader.readLine(), new int[2]);
  int n = c[0], q = c[1];
  int[] array = split(reader.readLine(), new int[n]);
  int[][] queries = new int[q][]; // Note, no size in the second part of the array creation.
  for (int i = 0; i < q; i++) {
    queries[i] = split(reader.readLine(), new int[2]);
  }
  ...
}