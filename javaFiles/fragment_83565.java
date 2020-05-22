import java.util.*;
public class ListAdd {

    static List<Integer> add2 (List<Integer> lst) throws Exception {

        List<Integer> result = lst.getClass().newInstance();
        for (Integer i : lst) result.add(i + 2);

        return result;
    }
}