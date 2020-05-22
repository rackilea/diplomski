import java.util.ArrayList;
import java.util.List;

public class Test {

public static void main(String[] args) {

    List<String> prodNames = new ArrayList<String>();
    prodNames.add("Dell Inspiron Laptop");
    prodNames.add("Apple iPad");
    prodNames.add("Samsung S4");

    // Search S4 and it will print Samsung S4 in Console
    System.out.println(search("S4", prodNames));
}

public static String search(String value, List<String> prodNames) {
    for (String name : prodNames) {
        if (name.contains(value)) {
            return name;
        }
    }

    return null;
}

}