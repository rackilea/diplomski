final class ImmutableInt {
  final int value; // no default value here means it must be set in the constructor

  public ImmutableInt( int val ) {
    this.value = val;
  }

  public int getValue() {
    return value;
  }
  // no setter because I don't want people to change it!
}