class Girl {
  private int age;
  Girl(int age) {
    this.age = age;
  }
  public boolean willGoOutWithGuy(boolean isGuyUgly) {
    return (age >= 22) && (!isGuyUgly);
  }
}

class Guy {
  private Girl girl = new Girl();
  private boolean isUgly = true;
  public boolean willGirlGoOutWithMe() {
    return girl.willGoOutWithGuy(isUgly);
  }
  // Guy doesn't have access to Girl's age. but he can ask her out. 
}