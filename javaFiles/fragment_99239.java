class CombinationLister {
  private final int[] counts;
  private final char[] str;
  private final int[] stk;
  private int p = 0;
  private int len = 0;

  CombinationLister(int[] counts) {
    this.counts = counts.clone();
    this.str = new char[Arrays.stream(counts).sum()];
    this.stk = new int[str.length];
  }

  void run() {
    for (int i = 0;;) {
      while (i < counts.length && counts[i] == 0) i++;
      if (i < counts.length) {
        --counts[i];
        str[len] = (char) ('a' + i);
        stk[p++] = i;
        if (++len == str.length) System.out.println(str);
        i = 0;
      } else if (p > 0) {
        i = stk[--p];
        --len;
        ++counts[i++];
      } else break;
    }
  }
}