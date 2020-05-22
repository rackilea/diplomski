package org.test.stackoverflow;

public class CanonicalName {

  public static void main(String[] args) {
    CanonicalName cn = new CanonicalName();
    cn.printClassNames();
  }

  private Anonymous anony;
  private MyAnony myAnony;

  public CanonicalName() {
    anony = new Anonymous() {
      public void printInterface() {
        System.out.println("Anony Name: " + getClass().getName());
        System.out.println("Anony CanonicalName: " + getClass().getCanonicalName());
      }
    };
    myAnony = new MyAnony();
  }

  public void printClassNames() {
    System.out.println("CanonicalName, Name: " + getClass().getName());
    System.out.println("CanonicalName, CanonicalName: " + getClass().getCanonicalName());
    anony.printInterface();
    myAnony.printInterface();
  }

  private static interface Anonymous {
    public void printInterface();
  }

  private static class MyAnony implements Anonymous {
    public void printInterface() {
      System.out.println("MyAnony Name: " + getClass().getName());
      System.out.println("MyAnony CanonicalName: " + getClass().getCanonicalName());
    }
  }
}