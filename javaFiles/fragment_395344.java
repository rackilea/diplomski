import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
  public static void main(String args[]) {
    String orig[] = { "a", "b", "b", "c" };
    String act[] = { "x", "b", "b", "y" };
    List origList = new ArrayList(Arrays.asList(orig));
    List actList = Arrays.asList(act);
    origList.retainAll(actList);
    System.out.println(origList);
  }
}