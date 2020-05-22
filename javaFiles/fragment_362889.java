public List<Interval> justReturnListIfNotEmpty(List<Interval> intervals) {
  if (intervals == null || intervals.size () == 0) {
    return null; 
  } else {
    return intervals;
  }
}