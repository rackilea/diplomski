public void onClick4(View v) 
{
    if (option4Text.getText().toString().equals(toString(answer))) {
        TextView questionText = (TextView) findViewById(R.id.question);
        correctAnswer();
        questionText.setText(questionTxt + "");
    }
}