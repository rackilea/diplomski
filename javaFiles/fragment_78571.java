public class Quiz {

    private int counter;
    private String question;
    private String rightAnswer;
    private String[] answers;

    public Quiz(int counter, String question, String rightAnswer, String... answers) {
        this.counter = counter;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.answers = answers;
    }

    public static void main(String[] args) {
        new Quiz(1, "one plus one", "two", "one", "two", "three");
        new Quiz(1, "one plus one", "two", "one", "two", "three", "four");
        new Quiz(1, "one plus one", "two", "one", "two", "three", "four", "five");
    }
}