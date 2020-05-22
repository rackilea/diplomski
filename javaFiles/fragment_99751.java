import java.lang.Math;
import java.util.ArrayList;

public class Test {

  // private class goes here

  public static void main(String[] argv) { new Test(); }

  public Test() {
    Numlist list = new Numlist();
    list.add(10);
    list.add(77810);
    list.add(4);
    list.add(100);
    list.add(1);
    list.add(290387423);
    list.add(23423);
    sort(list);
    System.out.println(list);
  }

  // function goes here
}