public enum HeuristicType {

  AdjacentMACsHeuristic(AdjacentMACs.class) {
    @Override public MergeHeuristic newHeuristic(ParentClass parent) {
      return new AdjacentMACs(parent);
    }
  },
  SimilarInterfaceNamesHeuristic(SimilarInterfaceNames.class) {
    @Override public MergeHeuristic newHeuristic(ParentClass parent) {
      return new SimilarInterfaceNames(parent);
    }
  },
  ... // other types here.
  ;

  private final Class<? extends MergeHeuristic> heuristicClass;
  public Class<? extends MergeHeuristic> getHeuristicClass() {
    return heuristicClass;
  }

  abstract public MergeHeuristic newHeuristic(ParentClass parent);

  private HeuristicType(Class<? extends MergeHeuristic> klass) {
    this.heuristicClass = klass;
  }

}