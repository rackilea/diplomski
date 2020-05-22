class DummyBean {
  private String dummy;

  public DummyBean(DummyBean another) {
    this.dummy = another.dummy; // you can access  
  }
}