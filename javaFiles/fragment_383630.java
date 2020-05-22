public class A {
  public void methodA() {
    System.out.println("A");
  }
}

public class B extends A {
  public void methodB() {
    System.out.println("B");
  }
}

public class Main {
  public static void main(String[] args) {
    A ab = new B();
    ab.methodB();
  }
}