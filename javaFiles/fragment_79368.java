public enum CompareChoice {
  ABS {
    public Comparator<? extends Path> comparator() {
      return Comparator.comparing(this::absCompare); // whatever absCompare means
    }
  },

  SIZE {
    public Comparator<? extends Path> comparator() {
      return Comparator.comparingLong(Files::size).thenComparing(ABS.comparator());
    }
  };


  public abstract Comparator<? extends Path> comparator();
}