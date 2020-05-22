public enum CompareChoice implements Comparator<Path> {

  SIZE {
    @Override
    public int compare(Path path1, Path path2) {
      int r = Long.compare(
        Files.size(path1),
        Files.size(path2)
      );
      if (r == 0) {
        return absCompare(path1, path2);
      }
      else {
        return r;
      }
    }
  };

  // rest of the methods:
  public static Path select(Comparator<? super Path> rule, Path path1, Path path2) {
    return rule.compare(path1, path2) <= 0 ? path1 : path2;
  }
}