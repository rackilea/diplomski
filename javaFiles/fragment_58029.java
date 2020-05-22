public class Player {
    private final User user;
    private AnswerSet answer;

    public Player(User p_user) {
        user = p_user;
    }

    public User getUser() {
        return user;
    }

    public void setAnswer(AnswerSet answer) {
        this.answer = answer;
    }

    public AnswerSet getAnswer() {
        return answer;
    }
}