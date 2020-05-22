class Edge {
  public final int v1, v2;

  public boolean equals(Object o) { return o != null && o instanceof Edge && o.hashCode() == hashCode(); }

  public int hashCode() { return v1 ^ v2; } // simple hash code, could be more sophisticated
}

Set<Edge> adjacencyList = new HashSet<Edge>();