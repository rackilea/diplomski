private static final Comparator<Thing> reverse = new Comparator<Thing>() {
    public int compare(Thing a, Thing b) {
      int av = a.getValue(), bv = b.getValue();
      return (av == bv) ? 0 : ((av < bv) ? -1 : +1);
    }
};