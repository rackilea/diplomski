class Player {
  protected int money;
  protected int stashSize;
  // and the connections parameter too...
  public Player(int money, int stashSize) {
    this.money = money;
    this.stashSize = stashSize;
  }
  public void sellWeed() {
    // work with money and stashSize here
  }
}

class Student extends Player {
  public Student() {
    super(0, 10); // no money and stashSize 10 for student
  }
}