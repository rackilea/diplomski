import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DuplicatesInLinkedLists
{
    public static void main(String[] args)
    {
        LinkedList<LinkedList<String>> lls =
            new LinkedList<LinkedList<String>>();
        LinkedList<String> list1 =
            new LinkedList<String>(Arrays.asList("dog", "cat", "snake"));
        LinkedList<String> list2 =
            new LinkedList<String>(Arrays.asList("donkey", "fox", "dog"));
        LinkedList<String> list3 =
            new LinkedList<String>(Arrays.asList("horse", "cat", "pig"));
        lls.add(list1);
        lls.add(list2);
        lls.add(list3);

        checkDuplicates(lls);
    }

    private static void checkDuplicates(
        List<? extends Collection<?>> collections)
    {
        for (int i = 0; i < collections.size(); i++)
        {
            for (int j = i + 1; j < collections.size(); j++)
            {
                Collection<?> ci = collections.get(i);
                Collection<?> cj = collections.get(j);
                boolean b = containsAny(ci, cj);
                System.out.println(
                    "Collection " + ci + " contains any of " + cj + ": " + b);
            }
        }
    }

    private static boolean containsAny(Collection<?> containing,
        Collection<?> contained)
    {
        Set<Object> set = new LinkedHashSet<Object>(contained);
        return containing.stream().anyMatch(e -> set.contains(e));
    }
}