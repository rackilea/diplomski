import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScoreReader {

    public static void main(String[] args) {
        BufferedReader reader = null;
        double average = 200.0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        int n = 1;
        String currentLine;
        double c;
        try {
            reader = new BufferedReader(new FileReader("QuizScores.txt"));
            System.out.println("--Quiz Scores--");
            while ((currentLine = reader.readLine()) != null) {
                try {
                    c = Double.parseDouble(currentLine);
                } catch (Exception ex) {
                    continue;
                }
                max = max > c ? max : c;
                min = min < c ? min : c;
                average += (c - average) / n;
                n++;
                System.out.println(c);
            }
            System.out.println("--Summary--");
            System.out.println("Average: " + average);
            System.out.println("Minimum: " + min);
            System.out.println("Maximum: " + max);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}