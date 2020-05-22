import java.util.Map;
public class QuestionInfo {

    private String question;
    private Map<String, String> variables;

    public QuestionInfo(String question, Map<String, String> variables) {
        this.question = question;
        this.variables = variables;
    }

    public String question() {
        return question;
    }

    public Map<String, String> vars() {
        return variables;
    }
}