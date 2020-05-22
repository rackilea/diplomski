static class Position {
  int x;
  int y;
  int z;
  Position(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  public boolean equals(Object b) {
    if (b instanceof Position) {
      Position other = (Position) b;
      return this.x == other.x && this.y == other.y && this.z == other.z;
    }
    return false;
  }
  public int hashCode() {
    return (Integer.valueOf(x).hashCode() ^ Integer.valueOf(y)
        .hashCode()) & Integer.valueOf(z).hashCode();
  }
}