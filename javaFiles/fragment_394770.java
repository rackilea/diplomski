private int correctAnswerColor, incorrectAnswerColor;
private String PREFS_NAME = "test";
private boolean isColored = false;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    correctAnswerColor = getResources().getColor(R.color.correct);

    //Sets color
    findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            findViewById(R.id.button).getBackground().setColorFilter(correctAnswerColor, PorterDuff.Mode.MULTIPLY);
            isColored = true;
        }
    });


    //Reads color
    SharedPreferences sp =  getSharedPreferences(PREFS_NAME,0 );
    isColored = sp.getBoolean("isValid", isColored);

    //Sets color of btt
    if(isColored) {
        findViewById(R.id.button).getBackground().setColorFilter(correctAnswerColor, PorterDuff.Mode.MULTIPLY);
    }
}

@Override
protected void onStop() {
    super.onStop();

    //Defines SharedPreferences & Saves data
    SharedPreferences sp =  getSharedPreferences(PREFS_NAME,0 );
    SharedPreferences.Editor ed = sp.edit();
    ed.putBoolean("isValid", isColored);

    //Commits edits
    ed.commit();
}