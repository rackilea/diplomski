class YourComparator implements Comparator<WeekSales> {
  private final Ordering<String> dayOrdering = Ordering.explicit(
    "Monday", "Tuesday", ... );

  @Override public int compare(WeekSales a, WeekSales b) {
    return dayOrdering.compare(a.getDay(), b.getDay());
  }
}