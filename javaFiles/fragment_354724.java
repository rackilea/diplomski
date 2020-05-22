import java.util.Scanner;



public class DiverScore  {
    static double score = 0;
    static double validDegreeOfDiff = 0;

    public static void main(String[] args) {
//        double[] score = new double[6];
        double[] score = inputAllScores(/*score*/);
        printArray(score);
    }

    public static double[] inputAllScores(/*double[] x*/) {
        Scanner s = new Scanner(System.in);
        double[] array_score = new double[6];
        for (int i = 0; i < 6; i++) {
            System.out.println("What is the score given by the judge?");
            array_score[i] = s.nextDouble();
        }
       return array_score;
    }

    public static void printArray(double[] j) {
        for (int i = 0; i < 6; i++) {
            System.out.println("The array is:" + j[i]);
        }
    }
}