Preferences prefs = Gdx.app.getPreferences("leaderboard");
Integer score = prefs.getInteger("highscore", 0); // if there is no highscore yet, the score will be 0

// gameplay logic...
Integer newScore = 1337;

if (newScore > score) {
    prefs.putInteger("highscore", score);
}