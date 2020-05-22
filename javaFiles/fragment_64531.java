import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An application requested by a SO user.
 */
public class ProductExample {

    /**
     * Returns a list containing all possible products of a list of lists of strings.
     */
    public static List<List<String>> product(List<List<String>> lists) {
        List<List<String>> result = new ArrayList<List<String>>();

        if (lists.isEmpty()) {
            result.add(new ArrayList<String>());
            return result;
        }

        List<List<String>> partial = product(lists.subList(0, lists.size() - 1));
        for (List<String> list: partial) {
            for (String s: lists.get(lists.size() - 1)) {
                List<String> listCopy = new ArrayList<String>(list);
                listCopy.add(s);
                result.add(listCopy);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(product(
                Arrays.asList(
                        Arrays.asList("a1", "a2"),
                        Arrays.asList("b1", "b2", "b3"),
                        Arrays.asList("c1", "c2"),
                        Arrays.asList("d1", "d2"))));
    }
}