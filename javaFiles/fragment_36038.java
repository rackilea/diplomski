public class Question {
    private String _question;
    private int _correctAnswerIndex;
    private Object[] _answers;

    public Question(String question, Object answers[], int correctAnswerIndex) {
        _question = question;
        _correctAnswerIndex = correctAnswerIndex;
        _answers = answers;
    }

    // Plus your getters and setters
}