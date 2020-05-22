import java.util.Scanner;

public class Averages 
{
 public static void main ( String[] args )
  {
     Scanner scan = new Scanner(System.in);
        int max = -9999;
        int min = 9999;
        int score = 0;
        int n;
        int c;
        int rowsum = 0;
        int rowMaxNumber = 0;
        int rowMinNumber = 0;
        int columnMax = 0;
        int columnMin = 0;
        double averageMin = 9999;
        double averageMax = 0;
        double avg = 0.0;
        double avgTotal = 0.0;
        double totalScore = 0;
        double totalStudent = 0;            

        System.out.println("How many rows?");
        n = scan.nextInt();

        for (int row = 1; row <= n; row++) {
            System.out.println("How many student in row " + row + "?");
            rowsum=0;
            c = scan.nextInt();
            totalStudent += c;

            for (int column = 1; column <= c; column++) {

                System.out.println("Score for student " + column + " in row " + row + "?");
                score = scan.nextInt();
                rowsum += score;
                totalScore += score;     

                if (score >= max) {
                    max = score;
                    columnMax = column;

                }
                if (score < min) {
                    min = score;
                    columnMin = column;
                }
            }
            avg = rowsum/c;
            if( avg >= averageMax){
                averageMax=avg;
                rowMaxNumber = row;

            }
            if( avg < averageMin){
                averageMin=avg;
                rowMinNumber = row;
            }
        }
        avgTotal = totalScore/totalStudent;

        System.out.println("Student " + columnMax + " of row " + rowMaxNumber + " was highest with " + max);
        System.out.println("Student " + columnMin + " of row " + rowMinNumber + " was lowest with " + min);
        System.out.println("Row " + rowMaxNumber + " had highest average with " + averageMax);
        System.out.println("Row " + rowMinNumber + " had lowest average with " + averageMin);
        System.out.println("Class average is " + avgTotal);
}
}