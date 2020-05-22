import java.util.Arrays;
import java.util.Collections;

public class Test {

    public static void main(String[] args) {

        String array = "AB AB AB AB";
        String[] part = array.split(" ");
        int cc = Collections.frequency(Arrays.asList(part), part[0]);
        System.out.println("Count: " + cc);

    }

}