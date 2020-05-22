import java.util.*;
public class Test {

    public static void main(String[] args) 
    {
        SortedMap<Integer, Double> a = new TreeMap<Integer, Double>();
        a.put(0, 12.3);
        a.put(1, 15.3);
        a.put(2, 17.3);

        System.out.println(a.get(1)); // prints 15.3
        System.out.println(a.get(2)); // prints 17.3

        a.remove(1);

        System.out.println(a.get(1)); // prints null
        System.out.println(a.get(2)); // prints 17.3
    }
}