ClassBase {
  private IntefaceBase parB;

  protected IntefaceBase getPar() {
    return parB;
  }

  public method1() {
    getPar().someMethod();
  }
}

ClassA extends ClassBase {
  private IntefaceA parA;

  protected IntefaceBase getPar() {
    return parA;
  }
}