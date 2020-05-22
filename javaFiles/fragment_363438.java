public XYSeries toXYSeries() {
  XYSeries xySeries = new XYSeries(getTitle());
  int length = getItemCount();
  for (int k = 0; k < length; k++) {
    xySeries.add(k + 1, getMinimumValue(k));
    // the new fast XYSeries implementation doesn't allow 2 values at the same X,
    // so I had to do a hack until I find a better solution
    xySeries.add(k + 1.000001, getMaximumValue(k));
  }
  return xySeries;
}