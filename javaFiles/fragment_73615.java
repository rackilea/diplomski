final String questions[] = {"Who's Tom?", "Who's Luca?", "Who's Flavie?"}
 final String answers[] = {"American", "Italian", "French"}

 // display question
answer_question.setOnClickListener(new View.OnClickListener() {
int CurrentQuestionIndex = 0;
public void onClick(View v) {
// make below line changes
ask_question.setText(question[(++CurrentQuestionIndex) % (questions.length-1)]);
// discuss question versus answer
EditText editText = (EditText) findViewById(R.id.tvReponseF);
if(editText.getText().toString().equals(answers[CurrentQuestionIndex]))  
{
    alertMessageRight();
} else {
    alertMessageFalse();


  }
} 
});