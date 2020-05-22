import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SameOrderTest
{
    public static void main(String[] args)
    {
        List<String> listA = new ArrayList<String>();
        listA.add("S");
        listA.add("A");
        listA.add("M");
        listA.add("P");
        listA.add("L");
        listA.add("E");
        listA.add("W");
        listA.add("O");
        listA.add("R");
        listA.add("D");

        List<String> listB = new ArrayList<String>();
        listB.add("A");
        listB.add("M");
        listB.add("S");
        listB.add("E");
        listB.add("L");

        List<String> listB0 = new ArrayList<String>(listB);
        Collections.sort(listB0, simpleSameOrderComparator(listA));

        List<String> listB1 = new ArrayList<String>(listB);
        Collections.sort(listB1, efficientSameOrderComparator(listA));

        System.out.println("A : "+listA);
        System.out.println("B0: "+listB0);
        System.out.println("B1: "+listB1);
    }

    // WARNING: Simple but VERY inefficient
    private static <T> Comparator<T> simpleSameOrderComparator(
        final List<T> reference)
    {
        return new Comparator<T>()
        {
            @Override
            public int compare(T t0, T t1)
            {
                return reference.indexOf(t0)-reference.indexOf(t1);
            }
        };
    }

    private static <T> Comparator<T> efficientSameOrderComparator(
        final List<T> reference)
    {
        final Map<T, Integer> map = new LinkedHashMap<T, Integer>();
        for (int i=0; i<reference.size(); i++)
        {
            map.put(reference.get(i), i);
        }
        return new Comparator<T>()
        {
            @Override
            public int compare(T t0, T t1)
            {
                return map.get(t0)-map.get(t1);
            }
        };
    }

}