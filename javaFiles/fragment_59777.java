public final class QuestionBuilder {

    private QuestionBuilder(){}

    public enum Type {

        LICENSE_NUMBER {
            @Override
            Question getQuestion() { return new LicenseNumberQuestion(); }
        },
        USP {
            @Override
            Question getQuestion() { return new USPQuestion(); }
        };

        abstract Question getQuestion();
    }

    public static Question getQuestion(Type type) {
        return type.getQuestion();
    }
}