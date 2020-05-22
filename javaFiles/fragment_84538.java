class OlympicCountry implements Comparable<OlympicCountry> {
  private int goldCount;
  private int silverCount;
  private int bronzeCount;
  private String name;

  // . . .

  public String toString() {
    return String.format("%s %d %d %d", name, goldCount, silverCount, bronzeCount);
  }

  public int compareTo(OlympicCountry other) {
    if (this.goldCount != other.goldCount)
      return this.goldCount > other.goldCount ? 1 : -1;
    if (this.silverCount != other.silverCount)
      return this.silverCount > other.silverCount ? 1 : -1;
    // . . .
    return this.name.compareTo(other.name);
  }
}