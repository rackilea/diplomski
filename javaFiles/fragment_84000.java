Arrays.sort(sortedOutput, new java.util.Comparator<Double[]>()
{
  public int compare(Double[]a, Double[]b)
  {
    return Double.compare(a[0], b[0]);
  }
});