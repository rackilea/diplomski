import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OtherNameThanArrays {

    public static void main(String[] args) {

        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(31,88,11,73,45));
        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(99,1,2,3,4));
        Collections.sort(numbers1);
        Collections.sort(numbers2);
        System.out.println(numbers1);
        System.out.println(numbers2);

    }
}