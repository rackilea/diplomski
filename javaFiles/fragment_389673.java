public class TrueFalseQuestion implements Question {
    static {
        QuestionFactory.registerType(QuestionType.TrueFalse, TrueFalseQuestion.class);
    }
    // Whatever else goes here
}