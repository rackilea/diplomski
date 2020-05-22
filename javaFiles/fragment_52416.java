public void check(View view) {
    // ADD HERE: update the value of the input
    uinput = edit1.getText().toString();

    if (uinput.equals(answerList[0])) {
        edit1.setBackgroundColor(Color.parseColor("#00FF00"));
        score++;
        score_view.setText(score);
    } else {
        edit1.setBackgroundColor(Color.parseColor("#FF0000"));
    }
}