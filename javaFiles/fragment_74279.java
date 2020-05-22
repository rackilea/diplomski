import java.util.LinkedList;
import java.util.List;

public class Main {

public static void main(String[] args) {
    List<String> subs = new LinkedList<>();
    subs.add("DD");
    subs.add("AA");
    subs.add("UU");
    subs.add("PP");
    String result = getSubString(subs, "DADDAUUPPA ");
    System.out.print(result);
}

private static String getSubString(List<String> subs, String myString) {
   if(subs !=null && subs.size() != 0) {
       String sub = subs.get(0);
       subs.remove(0);
       myString = getSubString(subs, myString.replace(sub, ""));
   }
   return myString;
}