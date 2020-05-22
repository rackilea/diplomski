class StringBundle {
  String[] strings;

  @Override
  public boolean equals(Object o) {
    // various checks
    return Array.deepEquals(this.strings, o.strings);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(strings);
  }
}