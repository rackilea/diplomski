package de.scrum_master.stackoverflow.q60103582;

public class MyClass {
  private Object1 o1;
  private Object2 o2;
  private Object3 o3;

  public MyClass(Object1 o1, Object2 o2, Object3 o3) {
    this.o1 = o1;
    this.o2 = o2;
    this.o3 = o3;
  }

  public void process(Object4 o4) {
    System.out.println("process - business Logic");
    Object2 result = getScore("dummy ID");
    Object3 obj = computeScore(result);
  }

  protected Object3 computeScore(Object2 result) {
    System.out.println("computeScore - business logic");
    return o3;
  }

  protected Object2 getScore(String id) {
    System.out.println("getScore - business logic");
    return o2;
  }
}