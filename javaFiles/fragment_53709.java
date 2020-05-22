import java.util.Arrays;

public final class ArrayWrapper {
  private final byte[] data;
  private final int hash;

  public ArrayWrapper(final byte[] data) {
    // strictly speaking we should make a defensive copy here,
    // but I *assume* (and should document) that the argument
    // passed in here should not be changed
    this.data = data;
    this.hash = Arrays.hashCode(data);
  }

  @Override
  public int hashCode() {
    return hash
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ArrayWrapper)) {
      return false;
    }
    ArrayWrapper other = (ArrayWrapper) o;
    return this.hash == other.hash && Arrays.equals(this.data, other.data);
  }
  // don't add getData to prevent having to do a defensive copy of data
}