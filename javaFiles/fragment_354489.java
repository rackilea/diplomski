import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class GradeChecker {

    public static void main(String[] args) {
        // TODO code application logic here
        double[] classGrades = new double[76];
        double classAverage = calculateAverageGrade(classGrades);


        fillArray(classGrades);
        for (int i = 0; i < classGrades.length; i++) {
            System.out.println(classGrades[i]);
        }
        //System.out.print(Arrays.toString(classGrades));
        System.out.print(classGrades.length);

    }

    public static void fillArray(double[] ary) {
        try {
            File arrayInput = new File("ClassGrades.txt");
            Scanner in = new Scanner(arrayInput);
            in.useDelimiter("\r\n");

            int i = 0;
            while (in.hasNextLine()) {
                ary[i++] = in.nextDouble();
            }
            in.close();
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    private static double calculateAverageGrade(double[] classGrades) {
        double gradeSum = 0;
        double gradeAverage = 0;
        for (int i = 0; i < classGrades.length; i++) {
            gradeSum = gradeSum + classGrades[i];
        }
        gradeAverage = gradeSum / classGrades.length;
        return gradeAverage;
    }
}