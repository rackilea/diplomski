import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("Item #1");
        list1.add("Item #2");

        list2.add("Item #3");
        list2.add("Item #4");

        System.out.println("List #1: " + list1);
        System.out.println("List #2: " + list2);

        list2.addAll(0, list1);

        System.out.println("Combined List: " + list2);

    }
}