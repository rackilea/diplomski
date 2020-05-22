import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SameOrderTest2
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

        List<String> listB0 = sorted(listA, listB);
        System.out.println("A : "+listA);
        System.out.println("B0: "+listB0);
    }

    private static <T> List<T> sorted(List<T> reference, List<T> toSort)
    {
        List<T> referenceList = new ArrayList<T>(reference);
        referenceList.retainAll(new LinkedHashSet<T>(toSort));
        return referenceList;
    }


}