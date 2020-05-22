import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
  public static void main(String[] args) {
    List<String> myList = Arrays.asList(new String[] { "aaa", "bbb", "ccc" });
    Iterator<String> iter1 = myList.iterator();
    System.out.println("iter1: " + iter1.next());
    System.out.println("iter1: " + iter1.next());
    Iterator<String> iter2 = myList.iterator();
    for (String s; iter2.hasNext();) {
      s = iter2.next();
      System.out.println("iter2: " + s);
    }
    System.out.println("iter1.hasNext(): " + iter1.hasNext());
    System.out.println("iter2.hasNext(): " + iter2.hasNext());
    System.out.println("iter1: " + iter1.next());
  }
}