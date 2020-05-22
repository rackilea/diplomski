import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<Object> listsAll = new ArrayList<Object>();
        listsAll.add(Arrays.asList(new Integer[] { 12, 45, 78 }));
        listsAll.add(Arrays.asList(new String[] { "s12", "s45", "s78" }));

        List<Integer> intList = new ArrayList<Integer>();
        intList.addAll((List<Integer>) listsAll.get(0));

        List<String> strList = new ArrayList<String>();
        strList.addAll((List<String>) listsAll.get(1));

        System.out.println(listsAll);
        System.out.println(intList);
        System.out.println(strList);
    }
}