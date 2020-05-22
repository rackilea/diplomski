import javax.swing.*;
import java.util.Random;

public class Random_int_array {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Total number of integers");
        int iTotalCount = Integer.parseInt(JOptionPane.showInputDialog(frame, "What is the total number of integers?"));

        int[] array = new int[iTotalCount];

        Random randomGenerator = new Random();

        for(int i=0; i < iTotalCount; i++){
            array[i] = randomGenerator.nextInt(1001);
        }

        // Now you can do whatever processing you would like to do
        // For the sake of this answer, I will just print the numbers

        for(int i=0; i < array.length; i++){
            System.out.println(array[i]);
        }

        // We should explicitly call exit because we used a form/window
        System.exit(0);
    }
}