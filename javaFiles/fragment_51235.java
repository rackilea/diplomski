import javax.swing.JOptionPane;


public class Quiz {

    private static String answer = null;
    private static String answer2 = null;
    private static String answer3 = null;

    static int nQuestions = 0;
    static int nCorrect = 0;

    //Main program, will call the questions to be answered in the quiz and checks if it's correct
    //counting both the number of questions and correct answers.
    public static void main(String[] args) {

        String[] questions = {"What is the planet with fastest orbit?\n",
                "The sum of 2 + 2.0 is?\n",
                "What is the sport the player shoots the ball in a basket\n"
        };

        nQuestions = questions.length;

        checkQuestions(questions, answer3);

        JOptionPane.showMessageDialog(null,"Out of " + nQuestions + " you had "+ nCorrect + " correct answers");
    }


    //The quiz #1
    static String ask(String question) {

        question += "A. Mercury, with a rotation that takes 58d 16h.\n";

        question += "B. Earth, with a rotation that takes 23h 56m.\n";

        question += "C. Mars, with a rotation that takes 24h 36m.\n";

        question += "D. Venus, with a rotation that takes 243d 26m.\n";

        question += "E. Uranus, with a rotation that takes 17h 14m.\n";

        String answer = JOptionPane.showInputDialog(question);

        answer = answer.toUpperCase();

        while (!answer.equals("A") && !answer.equals("B") && !answer.equals("C") && !answer.equals("D") && !answer.equals("E")) {

            JOptionPane.showMessageDialog(null,"Invalid answer. Please enter A, B, C, D, or E.");
            answer = JOptionPane.showInputDialog(question);
            answer = answer.toUpperCase();

        }

        return answer;

    }


    //The quiz #2
    static String ask2(String question2) {

        question2 += "A. 4\n";

        question2 += "B. 4.0\n";

        question2 += "C. 3\n";

        question2 += "D. 5\n";

        question2 += "E. -4\n";

        String answer2 = JOptionPane.showInputDialog(question2);

        answer2 = answer2.toUpperCase();

        while (!answer2.equals("A") && !answer2.equals("B") && !answer2.equals("C") && !answer2.equals("D") && !answer2.equals("E")) {

            JOptionPane.showMessageDialog(null,"Invalid answer. Please enter A, B, C, D, or E.");
            answer2 = JOptionPane.showInputDialog(question2);
            answer2 = answer2.toUpperCase();

        }

        return answer2;

    }


    //The quiz #3
    static String ask3(String question3) {

        question3 += "A. Basketball.\n";

        question3 += "B. Volleyball.\n";

        question3 += "C. Baseball.\n";

        question3 += "D. Football.\n";

        question3 += "E. Tennis\n";

        String answer3 = JOptionPane.showInputDialog(question3);

        answer3 = answer3.toUpperCase();

        while (!answer3.equals("A") && !answer3.equals("B") && !answer3.equals("C") && !answer3.equals("D") && !answer3.equals("E")) {

            JOptionPane.showMessageDialog(null,"Invalid answer. Please enter A, B, C, D, or E.");
            answer3 = JOptionPane.showInputDialog(question3);
            answer3 = answer3.toUpperCase();

        }

        return answer3;

    }


    //Answer verifier
    static void checkQuestions(String[] questions,  String correctAnswer) {
        String answer = ask(questions[0]);
        String correct = "D";
        if (answer.equals(correct)) {
            JOptionPane.showMessageDialog(null,"Correct!");
            nCorrect = nCorrect+1;
        }

        else if (answer.equals("A") || answer.equals("B") || answer.equals("C") || answer.equals("E")) {
            JOptionPane.showMessageDialog(null,"Incorrect! The answer is " + correct);
        }

        //checking Quiz#2
        String answer2 = ask2(questions[1]);
        String correct2 = "B";
        if (answer2.equals(correct2)) {
            JOptionPane.showMessageDialog(null,"Correct!");
            nCorrect = nCorrect+1;
        }

        else if (answer2.equals("A") || answer2.equals("C") || answer2.equals("D") || answer2.equals("E")) {
            JOptionPane.showMessageDialog(null,"Incorrect! The answer is " + correct2);

        }


        //checking Quiz#3
        String answer3 = ask3(questions[2]);
        String correct3 = "A";
        if (answer3.equals(correct3)) {
            JOptionPane.showMessageDialog(null,"Correct!");
            nCorrect = nCorrect+1;
        }

        else if (answer3.equals("B") || answer3.equals("C") || answer3.equals("D") || answer3.equals("E")) {
            JOptionPane.showMessageDialog(null,"Incorrect! The answer is " + correct3);

        }
    }
}