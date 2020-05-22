SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
if (sharedPreferences.contains("best_score")) {
    // we have a high score saved, load it...
    int numberOfPoints = sharedPreferences.getInt("best_score", -1);
    // here you'd like to do something with the value, for example display it.
} else {
    // there is no high score value - you should probably hide the "best score" TextView
}