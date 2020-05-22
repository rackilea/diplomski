public void answerTwo() {
RadioGroup questionTwoRadioGroup = (RadioGroup) findViewById(R.id.question_two_radio_group);
int radioButtonID = questionTwoRadioGroup.getCheckedRadioButtonId();

switch (radioButtonID) {
    case R.id.question_two_radio_one | question_two_radio_three:
        checkedTextNotAllCorrect += " 2";
        break;
    case R.id.question_two_radio_two:
        questionTwo = true;
        break;
}