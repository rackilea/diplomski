import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Testing {

    public static void main(String[] args) {
        int score = 0;
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        HashMap<Integer, String> intToString = new HashMap<>();

        intToString.put(1, "one");
        intToString.put(2, "two");
        intToString.put(3, "three");

        for (int count = 0; count < 5; ++count) {
            // "nextInt" is exclusive! Doing +1 converts [0;2] to [1;3]
            int random = rand.nextInt(3 + 1);

            // To see what number to guess
            System.out.println(random);

            String num = input.nextLine();

            // Get the string representation
            String response = intToString.get(random);

            if (num.equals(response)) {
                System.out.println("correct");
                ++score;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println(score);
    }
}