public class FabicTrackerUtils {
    private Answers answers;

    public setAnswers(Answers answers) {
        this.answers = answers;
    }

    private static void trackLoginActivity(LoginEvent loginEvent) {
        //...
        answers.logLogin(loginEvent);
    }
}