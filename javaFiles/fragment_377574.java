import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "\\Test\\src\\res\\questions.txt"; // the path of the text file
                                                                                            // that contains the
                                                                                            // questions
        Question[] questionList = TextFileStuff.fileAsString(path);
        takeTheQuiz(questionList);
    }

    public static void takeTheQuiz(Question[] questions) {
        int score = 0;
        Scanner userInput = new Scanner(System.in);
        for (int i = 0; i < questions.length; i++) {
            System.out.print("======================");
            System.out.print("Question " + (i + 1));
            System.out.println("======================");
            System.out.println(questions[i].getQuestion()); // Print the question
            String[] choices = questions[i].getChoices(); // get the choices
            for (int j = 0; j < choices.length; j++) { // loop through the choices
                System.out.println(choices[j]); // Print the choices
            }
            System.out.print("Input an answer : "); // Print the choices
            String answer = userInput.nextLine().toLowerCase();
            String[] answers = questions[i].getAnswers(); // get the answers
            for (int j = 0; j < answers.length; j++) { // loop through the answers
                if (answer.equals(answers[j])) { // check if the user's answer is correct
                    score++; // increment score
                }
            }
        }
        System.out.println("You scored " + score + " out of " + questions.length);
        if (score == questions.length) {
            System.out.println("Cheater!");
        } else if (score <= 2) {
            System.out.println("You suuuuck.");
        } else {
            System.out.println("Mediocre performance.");
        }
        userInput.close();
    }

}