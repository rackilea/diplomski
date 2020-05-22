private String highScore;
private String currentScore;

@override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(<your_layout>);

    highScore = getString(R.string.highscore_code);
    currentScore = getString(R.string.currentscore_code);
}