public static int[] sortFiltered(int[] src, IntPredicate predicate) {
  int[] filtered = IntStream.of(src).filter(predicate).sorted().toArray();
  int[] dst = new int[src.length];
  for (int i = 0, j = 0; i < src.length; i++) {
    dst[i] = predicate.test(src[i]) ? filtered[j++] : src[i];
  }
  return dst;
}