int[] c = {1, 34};
int[] d = {3, 1, 5};

int[] res= Stream.of(c, d)
  .flatMapToInt(Arrays::stream)
  .toArray();

  for (int re : res) {
      System.out.println(re);
  }