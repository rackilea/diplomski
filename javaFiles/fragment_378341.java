Comparator<List<String>> comparator = new Comparator<List<String>>() {
  @Override
  public int compare(List<String> o1, List<String> o2) {
    int diff = o1.get(0).compareTo(o2.get(0));
    if (diff == 0) {
      diff = o1.get(1).compareTo(o2.get(1));
      if (diff == 0) {
        diff = o1.get(2).compareTo(o2.get(2));
      }
    }
    return diff;
  }
};