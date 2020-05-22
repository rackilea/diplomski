import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<String> listOne = Arrays.asList("Silver", "White", "Grey",
                "Purple");
        List<String> listTwo = Arrays.asList("Petrol", "Hybrid");
        List<String> listThree = Arrays.asList("Toyota", "Micro");
        List<List<String>> totalList =  Arrays.asList(listOne,listTwo,listThree);

        new Test().printAllCases(totalList);
    }

    public void printAllCases(List<List<String>> totalList) {
        List<String> result = new ArrayList<String>(totalList.get(0));

        for(int index = 1; index < totalList.size(); index++) {
            result = combineTwoLists(result, totalList.get(index));
        }

        /* print */
        int count = 0;
        for(String s: result) {
            System.out.printf("%d. %s\n", ++count, s);
        }
    }

    private List<String> combineTwoLists(List<String> list1, List<String>   list2) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for(String s1 : list1) {
            for(String s2: list2) {
                sb.setLength(0);
                sb.append(s1).append(' ').append(s2);
                result.add(sb.toString());
            }
        }
        return result;
    }
}