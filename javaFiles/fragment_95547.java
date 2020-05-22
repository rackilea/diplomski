import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] pArgs) {
        List<Integer> numList = new ArrayList<Integer>();

        numList.add(53);
        numList.add(100);
        numList.add(56);
        numList.add(90);
        numList.add(68);
        numList.add(89);
        numList.add(78);
        numList.add(89);
        numList.add(80);

        int sum = 0, average = 0;
        for (Integer n : numList) {
            sum += n;
        }
        average = sum / numList.size();
        System.out.println("Average: " + average);

        Collections.sort(numList);
        for (Integer n : numList) {
            if (n > average) {
                System.out.println(n + "*");
            } else {
                System.out.println(n);
            }
        }

    }
}