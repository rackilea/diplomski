public class CompoundQuestion {
    private String question;
    private String[] answers;

    public String getQuestion () { return question; }

    public String[] getAnswers () { return answers; }

    public CompoundQuestion (String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }

    public CompoundQuestion (String question, String... answers) {
        this(question, answers);
    }
}