A a = new A(){
  @Override
  public int hashCode() {
    return System.identityHashCode(this);
  }
};