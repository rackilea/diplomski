import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

public class Random_int_array {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Total number of integers");
        int iTotalCount = Integer.parseInt(JOptionPane.showInputDialog(frame, "What is the total number of integers?"));

        // Can also be written as: ArrayList<Integer> array = new ArrayList<>();
        // in newer versions of Java.
        ArrayList<Integer> array = new ArrayList<Integer>();

        Random randomGenerator = new Random();

        for(int i=0; i < iTotalCount; i++){
            array.add(randomGenerator.nextInt(1001));
        }

        // Now you can do whatever processing you would like to do
        // For the sake of this answer, I will just print the numbers

        for(int i=0; i < array.size(); i++){
            System.out.println(array.get(i));
        }

        // We should explicitly call exit because we used a form/window
        System.exit(0);
    }
}