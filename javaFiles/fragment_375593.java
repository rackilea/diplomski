class SavedValues {

    private static final String keyP1fName = String.valueOf(R.string.player_1_name_key);
    private static final String keyP1Game = String.valueOf(R.string.player_1_game_key);
    private static final String keyP2fName = String.valueOf(R.string.player_2_sname_key);

    private MainGame mainGame;


    /**************************** THIS PART I CHANGED *******************/


    private SharedPreferences mPrefs;

    SavedValues(MainGame mainGame) {
        this.mainGame = mainGame;
        mPref = mainGame.getPreferences(Context.MODE_PRIVATE);
    }

    /**********************************************/

    //private SharedPreferences mPrefs = mainGame.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

    //SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

    void saveMainGameValues() {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(keyP1fName, mainGame.fullNameP1.getText().toString());
        editor.putString(keyP1Game, mainGame.gameScoreP1.getText().toString());

        editor.putString(keyP2fName, mainGame.fullNameP2.getText().toString());
        editor.putString(keyP2Game, maingGame.gameScoreP2.getText().toString());
        editor.apply();
    }

    void getMainGameValues() {
        mPrefs = mainGame.getPreferences(Context.MODE_PRIVATE);
        if (mPrefs.contains(keyP1fName)) {
            mainGame.fullNameP1.setText(mPrefs.getString(keyP1fName, "Player 1"));
            mainGame.gameScoreP1.setText(mPrefs.getString(keyP1Game, "0"));

            mainGame.fullNameP2.setText(mPrefs.getString(keyP2fName, "Player 2"));
            mainGame.gameScoreP2.setText(mPrefs.getString(keyP2Game, "0"));
        }}
}