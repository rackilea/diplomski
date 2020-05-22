private void getNextQuestion(final int i) {
    setQuestion(false); //disable buttons
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            if (counter < 6) {
                setQuestion();
            }else {
                // if over 5 do this
                Intent intent = new Intent(Level6.this, NextLevel.class);
                Bundle a = new Bundle();
                a.putInt("score", score);
                a.putInt("level", 6);
                intent.putExtras(a);
                startActivity(intent);
                setQuestion(true); //enable buttons
                finish();
            }
        }
    },500);
}