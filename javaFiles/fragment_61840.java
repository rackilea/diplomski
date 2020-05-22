public class QuestionModel {

private String QuestionString;
private ArrayList<String> Answer;

public QuestionModel(String questionString, ArrayList answer) {
    QuestionString = questionString;
    Answer = answer;
}

public String getQuestionString() {
    return QuestionString;
}

public void setQuestionString(String questionString) {
    QuestionString = questionString;
}

public ArrayList getAnswer() {
    return Answer;
}

public void setAnswer(ArrayList answer) {
    Answer = answer;
}