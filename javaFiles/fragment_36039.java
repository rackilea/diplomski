public class QuestionActivity extends Activity {
    private ArrayList<Question> _questions;
    private int _currentQuestionIndex;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);

        init();
    }

    private void init() {
        //Add your questions...

        TextView questionField = (TextView)findViewById(R.id.question_layout_question_field);
        questionField.setText(_questions.get(_currentQuestionIndex).getQuestion());

        //Get and set your other fields.
    }
}