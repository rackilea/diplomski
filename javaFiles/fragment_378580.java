import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(new Integer[]{ 1 , 1 , 1 , 1 , 1 })); 
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{ 2 , 2 , 2 , 2 , 2 })); 
        List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(new Integer[]{ 6 , 6 , 6 , 6 , 6 })); 

        List<Integer> list4 = IntStream.range(0, list1.size()).mapToObj(i -> (list1.get(i) + list2.get(i) + list3.get(i))/3).collect(Collectors.toList());

        System.out.println(list4); // Prints [3, 3, 3, 3, 3]
    }

}