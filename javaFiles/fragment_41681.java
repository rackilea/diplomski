import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<String> strings = new Vector<String>();

        strings.add("lorem");
        strings.add("ipsum");
        strings.add("dolor");
        strings.add("sit");

        int i = 0;

        Iterator<String> iter = strings.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());

            // Modify the list in the middle of iteration.
            if (i++ == 1)
                strings.remove(0);
        }
    }
}