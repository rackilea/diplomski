public enum Mode {
  ONE {
    @Override
    public MyType get() { Factory.getInstance().getFirst(); }
  },
  TWO {
    @Override
    public MyType get() { Factory.getInstance().getSecond(); }
  };

  public abstract MyType get();

  // Other methods removed for clarity
}