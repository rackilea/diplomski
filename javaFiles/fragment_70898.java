class Dist implements Comparable<Dist> {
  final int vertex;
  final int distance;

  public int compareTo(Dist other) {
    return Integer.compare(distance, other.distance);
  }
}