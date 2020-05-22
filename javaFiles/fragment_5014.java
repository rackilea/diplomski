import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Filling1DArray {

    /**
     * Ask the user to enter an integer
     * @return The integer the user entered or -1 if the input is not an integer
     */
    private static int nextScore() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog("Please enter the score (or -1 to stop)"));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String [] args) {

        // Dynamic list to hold the user input
        List<Integer> scores = new ArrayList<>();

        // Get user input until she enters -1 or some non-integer
        int score;
        while ((score = nextScore()) != -1)
            scores.add(score);

        // Compute the sum using stream API
        System.out.println(scores.stream().reduce((a, b)->a+b).orElse(-1));

        // Or a simple ranged-for
        int sum = 0;
        for (int s : scores) sum += s;
        System.out.println(sum);
    }
}