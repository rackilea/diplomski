import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class stackexample {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList( 5, 0, 0, 2 );
        int occurrences = Collections.frequency(values, 0);
        System.out.println("occurrences of zero is " + occurrences); //shows 0 but answer should be 2
    }
}