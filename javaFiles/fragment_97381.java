public enum SingletonObjectHolder {
  private final Object hold;
  A_INSTANCE(new A()), B_INSTANCE(new B())...

  public Object getSingleton() { return hold; }
  private SingletonObjectHolder(Object o) { hold = o };