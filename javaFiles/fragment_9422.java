import java.util.Scanner;

class ClassNamesShouldBeCapitalized
{
    public static void main(String[] args)
    {
        Scanner gradeScanner = new Scanner(System.in);

        int gradeCounter = 0;
        int gradeTotal = 0;

        System.out.println("Input grade: " );

        while(gradeScanner.hasNextInt()) {
            int nextGrade = gradeScanner.nextInt();
            System.out.println("Recorded grade: " + nextGrade);
            System.out.println("Input grade: " );
            gradeTotal += nextGrade;
            gradeCounter++;
        }

        if (gradeCounter > 0) {
            double avg = gradeTotal / gradeCounter;
            System.out.println("Here's your average: " + avg);
        }
        else {
            System.out.println("No grades found.");
        }
    }
}