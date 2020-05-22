public abstract class MyApi {

  public final boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if (other instanceof MyApi) {
      return equals((MyApi)other);
    }
    return false;
  }

  protected abstract boolean equals(MyApi other);

}