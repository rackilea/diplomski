String questions[] = {"question1", "question2".....};

if (isQuestionSelected(1)) {
  setNewAnswersHere()
}

private boolean isQuestionSelected(int number) {    
    return textview.gettext().equals("question" +  number) && radioA.isSelected == true;
}

private void setNewAnswersHere(){
    RadioA.setText("newAnswerHere");
    RadioB.setText("......);
}