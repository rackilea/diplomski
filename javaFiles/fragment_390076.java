class DataPoint implements Comparable<DataPoint> {
  @Override
  public int compareTo(DataPoint o) {
    return X.compareTo(o.X);
  }
}