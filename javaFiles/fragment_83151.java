import java.util.*;

public class list {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

LinkedList<String> names = new LinkedList<>();
String s = scan.nextLine();
List<String> l = new ArrayList<>();
String k = "";
for (int i = 0; i < s.length();i++) {
    if (s.charAt(i) == " ".charAt(0)) {
        l.add(k);
        k="";
    } else {
        k = k + s.charAt(i);
    }
}
final String[] letters = {"s", "S", "e", "E"};
for (String ss : l) {
    boolean isfalse = true;
  for (String letter : letters) {
      if (ss.startsWith(letter)) {
          names.addFirst(ss);
          isfalse = false;
          break;
      }
  }
  if (isfalse) {
      names.addLast(ss);
  }
}
  for (String name : names) {
      System.out.println(name);
  }}}