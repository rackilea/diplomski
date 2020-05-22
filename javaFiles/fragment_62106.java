class Dog extends Animal {
  private static int liveOnes = 0;

  public Dog() {
    liveOnes++;
  }

  public static int getHowManyAlive() { return liveOnes; }
}