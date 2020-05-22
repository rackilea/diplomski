public class QuestionFactory {
    static final Map<QuestionType, Constructor<? extends Question>> map =
        new HashMap<QuestionType, Class<? extends Question>>();

    public static void registerType(QuestionType quesType, Class<? extends Question> ques) {
        map.put(quesType, ques.getConstructor());
    }

    public static Question createQuestion(QuestionType quesType) {
        return map.get(quesType).newInstance();
    }
}