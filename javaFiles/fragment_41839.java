public void onCreate(Bundle bundle) {
    ....
    int score = 0;
    TextView scoreTextView = (TextView) findViewById(R.id.tvResult);

    Bundle extras = getIntent().getExtras(); 
    if(extras !=null) {
       score = extras.getInt("newResultVariable", 0);
    }

     scoreTextView.setText("Game over!\nYour score is:\n" + score); 
     ....
}