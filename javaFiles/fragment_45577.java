import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number from 9 to 18: ");
        int num9a18 = input.nextInt();
        if (num9a18 < 9 || num9a18 > 18) {
            System.out.println("This number is invalid!");
        }
        double result;
        List<Double> results = new ArrayList<Double>();
        for (int i = 0; i < num9a18; i++) {
            result = resultFromRandomRadius(1, 6);
            results.add(result);
        }
        System.out.println("................SORTING.................");
        Collections.sort(results);
        for (double res : results) {
            System.out.println(res);
        }
        System.out.println("..........................................");
        System.out.println("................REVERSING.................");
        Collections.reverse(results);
        for (double res : results) {
            System.out.println(res);
        }
    }

    public static double resultFromRandomRadius(int small, int big) {
        double PI = 3.141592564;
        int results = ((int) (Math.random() * (big - small + 1)) + small);
        return results * results * PI;
    }
}