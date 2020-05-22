import java.util.*;

public class Foo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();;
        list.add("Hello");
        list.add("There");
        list.add(null);

        for (String str: list) {
            System.out.println(str != null ? str : "<null>");
        }

        ArrayList<Integer> indexes = new ArrayList<Integer>();
        int index = 0;
        for (String str: list) {
            if (str == null) {
                indexes.add(index);
            }
            ++index;
        }
        for (Integer thisIndex: indexes) {
            System.out.println(thisIndex);
        }
    }
}