import java.util.Scanner;

public class Degree {
    private static final String[] courses = {"MATH5070", "MATH5080", "STAT6020", "STAT6050", "DATA6200", "DATA6300"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sumOfPoints = 0;

        for (String course : courses) {
            System.out.println("Enter Grade (A, B, C) for " + course);
            String letterGrade = input.nextLine().toUpperCase();
            sumOfPoints += getPointsForLetterGrade(letterGrade);
        }
        double gpa = sumOfPoints / courses.length;
        System.out.println("Total GPA points = " + gpa);
    }

    private static int getPointsForLetterGrade(String letterGrade) {
        int pointsForLetter = 0;
        switch (letterGrade) {
            case "A":
                pointsForLetter = 4;
                break;
            case "B":
                pointsForLetter = 3;
                break;
            case "C":
                pointsForLetter = 2;
                break;
            default:
                System.out.println("Wrong");
                break;
        }
        return pointsForLetter;
    }
}