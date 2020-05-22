String questions[] = {"question1", "question2".....};

if (isQuestion1Selected()) {
  setNewAnswersHere()
}

private boolean isQuestionSelected() {    
    return textview.gettext().equals("question1") && radioA.isSelected == true;
}

private void setNewAnswersHere(){
    RadioA.setText("newAnswerHere");
    RadioB.setText("......);
}