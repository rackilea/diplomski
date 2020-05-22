final String questions[] = {"Who's Tom?", "Who's Luca?", "Who's Flavie?"}
 final String answers[] = {"American", "Italian", "French"}

 // display question
answer_question.setOnClickListener(new View.OnClickListener() {
int CurrentQuestionIndex = 0;
public void onClick(View v) {

ask_question.setText(question[CurrentQuestionIndex]);

// discuss question versus answer
EditText editText = (EditText) findViewById(R.id.tvReponseF);
if(editText.getText().toString().equals(answers[CurrentQuestionIndex]))  
{
    alertMessageRight();
} else {
    alertMessageFalse();


  }


 if(CurrentQuestionIndex++ == questions.length-1){
CurrentQuestionIndex =0;
      }
    } 

    });