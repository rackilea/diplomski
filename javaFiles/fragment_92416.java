import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class HelloWorld {
  public static void main(String[] args) {
    String word = "kiraiki";
    Set<String> process = new HashSet<String>();
    System.out.println("Initial word: " + word);
    process.add(word);
    for (int i = 1; i < 4; ++i) {
      System.out.println("Removing " + i);
      Set<String> next = new HashSet<String>();
      for (String current : process) {
        List<String> result = removeOne(current, "i");
        for (String r : result) {
          next.add(r);
        }
      }
      for (String r : next) {
        System.out.println(r);
      }
      process = next;
    }
  }

  public static List<String> removeOne(String word, String c) {
    List<String> oneRemoved = new ArrayList<String>();
    String[] parts = word.split(c, -1);
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < parts.length-1; ++i){
      for (int j = 0; j < parts.length; ++j){
        String part = parts[j];
        builder.append(part);
        if (i != j){
          builder.append('i');
        }
      }
      oneRemoved.add(builder.substring(0, builder.length() - 1).toString());
      builder.setLength(0);
    }
    return oneRemoved;
  }
}