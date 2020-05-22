import java.util.*;

public class Main {

  public static void main(String[] args) {
    List<Foo> foos = new ArrayList<Foo>();
    foos.add(new Foo());
    foos.add(new Foo());
    foos.add(new Foo());
    System.out.println("foos="+foos);
    foos.get(1).n = 1;
    System.out.println("foos="+foos);
  }

  static class Foo {
    int n = 0;
    @Override 
    public String toString() {
      return String.valueOf(n);
    }
  }
}