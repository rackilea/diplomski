import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
        String inputs[] = { "100.26kg", "100g", "100 pounds", "100litre"};

        String weight, unit;

        for(String input : inputs){
            Scanner scan = new Scanner(input);
            weight = scan.findInLine("\\d+(\\.\\d+)?");
            unit = scan.next();//scan.next("\\w+");

            System.out.println(weight);
            System.out.println(unit);
        }
    }
}