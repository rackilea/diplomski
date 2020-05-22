TextView textView_displayquestion;
Button button_check;
EditText editText_ans;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    textView_displayquestion = (TextView)findViewById(R.id.displayquestion); //change as per your id
    button_check = (Button)findViewById(R.id.buttoncheck); //change as per your id
    editText_ans = (EditText)findViewById(R.id.answer); //change as per your id
    Displayquestions();
}