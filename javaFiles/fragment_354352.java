class ImmutableInt {
  int value;
  public ImmutableInt( int val ) {
    this.value = val;
  }
  public int getValue() {
    return value;
  }
  // no setter because I don't want people to change it!
}