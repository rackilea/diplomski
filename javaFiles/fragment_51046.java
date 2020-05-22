class SomeClass {
  private String text;
  // all your fields and methods go here

  public SomeClass(SomeClass copyInstance) {
    this.text = new String(copyInstance.text);
  }
}