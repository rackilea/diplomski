new View.OnClickListener() {
  private boolean isChecked = true; // HERE

  @Override
  public void onClick(View v) {
    RadioButton checkedRadioButton = ((RadioButton) v);
    if (isChecked) {
      if (checkedRadioButton.isChecked() && CorrectAnswer == 1) {
        score++;
        isChecked = false;
      }
    }
  }
};