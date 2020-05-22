public static void main(String[] args) throws IOException {
  long nanos = System.nanoTime();
  myMain();
  nanos = System.nanoTime() - nanos;
  System.out.printf("Time: %sms%n", MILLISECONDS.convert(nanos, NANOSECONDS));
}

static void myMain() throws IOException {
  try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
    int[] counts = split(reader.readLine(), new int[2]);
    int n = counts[0], q = counts[1];
    int[] array = split(reader.readLine(), new int[n]);
    int[] indices = new int[n];
    for (int i = 0; i < q; i++) {
      int[] query = split(reader.readLine(), new int[2]);
      indices[query[0] - 1]++;
      if (query[1] < n) {
        indices[query[1]]--;
      }
    }
    for (int i = 1; i < n; i++) {
      indices[i] += indices[i - 1];
    }
    sort(array, 200_000);
    sort(indices, 200_000);
    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += (long)array[i] * indices[i];
    }
    System.out.println(sum);
  }
}

static void sort(int[] array, int n) {
  int[] counts = new int[n+1];
  for (int element: array) {
    counts[element]++;
  }
  int current = 0;
  for (int i = 0; i < counts.length; i++) {
    Arrays.fill(array, current, current + counts[i], i);
    current += counts[i];
  }
}

static int[] split(String s, int[] a) {
  int n = 0, aIndex = 0;
  for (int sIndex = 0, sLength = s.length(); sIndex < sLength; sIndex++) {
    char c = s.charAt(sIndex);
    if (c == ' ') {
      a[aIndex++] = n;
      n = 0;
    } else if ('0' <= c && c <= '9') {
      n = n * 10 + (c - '0');
    }
  }
  a[aIndex] = n;
  return a;
}