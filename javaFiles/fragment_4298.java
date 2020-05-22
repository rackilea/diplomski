import java.util.ArrayList;
import java.util.Scanner;

public class NumberAnalyzer {

    private ArrayList<Number> list;

    public NumberAnalyzer() {
    }

    public NumberAnalyzer(String numbers) {
        list = new ArrayList<Number>();
        String nums = numbers;
        Scanner chopper = new Scanner(nums);
        while (chopper.hasNext()) {
            list.add(new Number(chopper.nextInt()));
        }
        chopper.close();
    }

}