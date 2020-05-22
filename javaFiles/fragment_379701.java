package sof_6462281;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demonstrate the fact that the Map uses key.equals(k) to
 * test for key equality.  Further demonstrate that it is a 
 * very bad idea to use mutable collections are keys to maps.
 */
public class ListAsKey {
    public static void main(String[] args) {
        Map<List<A>, Boolean>  map = new HashMap<List<A>, Boolean>();

        List<A> alist = new ArrayList<A>();
        map.put(alist, true);
        for (List<A> a : map.keySet()) {
            Boolean b = map.get(a);
            System.out.format("\t%s(ArrayList@%d) => %s\n",a, a.hashCode(), map.get(a)); 
        }

        // you changed your list after the put, didn't you?
        alist.add(new A());
        for (List<A> a : map.keySet()) {
            Boolean b = map.get(a);
            System.out.format("\t%s(ArrayList@%d) => %s\n",a, a.hashCode(), map.get(a)); 
        }

        alist.clear();
        for (List<A> a : map.keySet()) {
            Boolean b = map.get(a);
            System.out.format("\t%s(ArrayList@%d) => %s\n",a, a.hashCode(), map.get(a)); 
        }
    }
    public static final class A { /* foo */ }
}