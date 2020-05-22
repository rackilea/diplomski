// Get an instance
Preferences prefs = Gdx.app.getPreferences("Highscores");

// Save a high score
prefs.putInteger("high1", 999);
// Make sure it is saved
prefs.flush();

// Get the high score (the 0 is default, in case no high1 is set yet)
int high1 = prefs.getInteger("high1", 0);