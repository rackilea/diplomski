public enum Name {
  John(23), Mary(20)

  private int age;

  private Name(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }
}