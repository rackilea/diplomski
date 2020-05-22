class CombinationLister {
  private final int[] counts;
  private final int length;

  CombinationLister(int[] counts) {
    this.counts = counts.clone();
    this.length = Arrays.stream(counts).sum();
  }

  private void list(String prefix) {
    if (prefix.length() == length) {
      System.out.println(prefix);
    }
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > 0) {
        --counts[i];
        list(prefix + (char) ('a' + i));
        ++counts[i];
      }
    }
  }

  void run() {
    list("");
  }
}