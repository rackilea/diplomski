import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Grader {

    public static void main(String[] args) throws IOException {
        int count = 0;
        int sum = 0;
        double ave = 0;
        int incorrectCount = 0;
        String correctGrades = "";
        String incorrectGrades = "";

        // Read file input
        JFileChooser chooser = new JFileChooser();
        if (JFileChooser.APPROVE_OPTION != chooser.showOpenDialog(null)) {
            return;
        }
        File file = chooser.getSelectedFile();

        // Scan chosen document
        Scanner s = new Scanner(file);


        // While the document has an Int
        while (s.hasNextInt()) {
            // Convert our inputs into an int
            int grade = Integer.parseInt(s.next());

            if (grade >= 0 && grade <= 100) {
                // adds sum
                sum += grade;
                // increments correct count
                count++;
                // displays valid grades
                correctGrades += Integer.toString(grade) + "\n";
            } else {
                // increments incorrect count
                incorrectCount++;
                // displays invalid grades
                incorrectGrades += Integer.toString(grade) + "\n";
            }
        }
        // Created average variable 
        ave = sum / count;

        // bada bing bada boom
        System.out.println("The number of correct grades were " + correctGrades);
        System.out.println("The average score on this test was " + ave + "\n");
        System.out.println("The number of incorrect grades were " + incorrectCount + "\n");
        System.out.println("The incorrect values for the grades were " + "\n" + incorrectGrades);

    }

}