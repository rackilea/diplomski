public void updateTheScore(int n) {
    TextView scoreView = (TextView) findViewById(R.id.score_text_view);
    int score = Integer.parseInt(scoreView.getText().toString());
    score += n;
    scoreView.setText(score); // <---- this isn't working
    numberGenerator();
}