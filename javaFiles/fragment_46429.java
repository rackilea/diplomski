public class StringOptionsQuestion extends Question {

    public StringOptionsQuestion(String question, String answer, String... alts) {
        super(question, answer, validateAlternatives(alts));
    }

    private static String[] validateAlternatives(String[] alternatives) {
        if (alternatives.length == 0) { 
           throw new IllegalArgumentException();
        }
        return alternatives;
    }
}