import java.util.ArrayList;
import java.util.Scanner;

public class Grades {
    public static void main (String[] args) {
        ArrayList<Integer> bestStudentPosition  = new ArrayList<Integer>();
        ArrayList<Integer> worstStudentPosition = new ArrayList<Integer>();
        Scanner            input                = new Scanner(System.in);
        System.out.print("How many students are in your class? ");
        int      totalStudents = Integer.parseInt(input.nextLine());
        String[] names         = new String[totalStudents];
        double[] scores        = new double[totalStudents];
        double   maxGrade      = 0;
        double   minGrade      = 0;
        double   avg           = 0;
        double   sum           = 0;
        for (int i = 0; i < totalStudents; i++) {
            System.out.print("Name: ");
            names[i] = input.next();
            System.out.print("Score: ");
            scores[i] = input.nextDouble();
            sum += scores[i];
            if (i == 0) {
                minGrade = scores[0];
            }
            if (scores[i] > maxGrade) {
                bestStudentPosition.clear();
                maxGrade = scores[i];
                bestStudentPosition.add(new Integer(i));
            } else if (scores[i] == maxGrade) {
                bestStudentPosition.add(new Integer(i));
            }
            if (i > 0 && scores[i] < minGrade) {
                worstStudentPosition.clear();
                minGrade = scores[i];
                worstStudentPosition.add(new Integer(i));
            } else if (scores[i] == minGrade) {
                worstStudentPosition.add(new Integer(i));
            }

        }

        avg = sum / totalStudents;
        System.out.print("Highest score: ");
        for (Integer position : bestStudentPosition) {
            System.out.println(maxGrade + ", " + names[position]);
        }
        System.out.print("Lowest score: ");
        for (Integer position : worstStudentPosition) {
            System.out.println(minGrade + ", " + names[position]);
        }

        System.out.printf("Average: %3.2f", avg);

    }
}