public class Example {
  public static int numero;
}

public class Implementation {

  public static void main (String args[]) {
    Example ex1 = new Example();
    Example ex2 = new Example();
    Example.numero=10;
    System.out.println("Value for instance 1 is: " + ex1.numero);
    System.out.println("Value for instance 2 is: " + ex2.numero);
  }
}