import java.util.Scanner;

class Health {

    public static void main(String[] args) {

        int in1 = firstScore();
        int in2 = secondScore();
        revealAge(in1, in2);
        System.exit(0);

    }

    public static int firstScore() {

        Scanner firstScores = new Scanner(System.in);

        System.out.println("What score did you recieve in your first exercise out of 40?");

        int score1 = firstScores.nextInt();

        return score1;

    }

    public static int secondScore() {

        Scanner secondScores = new Scanner(System.in);

        System.out.println("What score did you recieve in your second exercise out of 40?");

        int score2 = secondScores.nextInt();

        return score2;

    }

    public static void revealAge(int score1, int score2) {

        int average = (score1 + score2) / 2;

        int fitnessAge = (((average * 8) / 5) + 10);

        System.out.println("Your average score is " + average + ".");

        System.out.println("Your PC Fit age is " + fitnessAge + ".");

    }

}