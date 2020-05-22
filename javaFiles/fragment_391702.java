interface Y { //Assume Y has two methods
   void m1();
   void m2();
}

public enum X implements Y {
  A (0),
  B (1);
  private final Y y;
  X(int value) { this.y = YBuilder.create(value); }

  //Then delegate to y to implement the Y interface

  public void m1() { y.m1(); return; }
  public void m2() { y.m2(); return; }
};