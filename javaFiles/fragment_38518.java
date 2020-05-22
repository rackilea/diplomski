public class YourCustomController implements Initializable {

    @FXML Label question;

    //...
    public void initialize() {
    //...
    }

    public void setQuestion(Question q) {
         question.setText(q.getQuestion();
    }
}