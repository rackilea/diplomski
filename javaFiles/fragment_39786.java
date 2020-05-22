import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CartesianProduct {

    public static Set<Set<Object> > cartesianProduct(Set<?>... sets) {
        if (sets.length < 2)
            throw new IllegalArgumentException(
                    "Can't have a product of fewer than two sets (got " +
                    sets.length + ")");

        return _cartesianProduct(0, sets);
    }

    private static Set<Set<Object> > _cartesianProduct(int index, Set<?>... sets) {
        Set<Set<Object> > ret = new TreeSet<Set<Object> >(new Comparator<Set<Object> >() {
            @Override
            public int compare(Set<Object> o1, Set<Object> o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

        if (index == sets.length) {
            ret.add(new TreeSet<Object>());
        } else {
            for (Object obj : sets[index]) {
                for (Set<Object> set : _cartesianProduct(index+1, sets)) {
                    set.add(obj);
                    ret.add(set);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Map<String, Set<String> > dataMap = new HashMap<String, Set<String> >();
        dataMap.put("A", new TreeSet<String>(Arrays.asList("a1", "a2")));
        dataMap.put("B", new TreeSet<String>(Arrays.asList("b1", "b2")));
        dataMap.put("C", new TreeSet<String>(Arrays.asList("c1", "c2")));

        System.out.println(cartesianProduct(dataMap.values().toArray(new Set<?>[0])));
    }

}