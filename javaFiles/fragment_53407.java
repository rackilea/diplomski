public void onRadioButtonClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();

    // Check which radio button was clicked
    switch(view.getId()) {
        case R.id.correct_answer: // this is id/krzyzyk
            if (checked)
                score++;
                // Go to next question
            break;
        case R.id.wrong_answer:
            if (checked)
                // Go to next question.
            break;
    }
}