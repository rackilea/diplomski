if (Gdx.input.isKeyPressed(Input.Keys.P)) {
    // Use a helper so that a held-down button does not continuously switch between states with every tick
    if (pauseHelper) {
        if (isPaused) {
            Util.toConsole ("No longer paused");
            isPaused = false;
        }
        else {
            Util.toConsole ("Now paused");
            isPaused = true;
        }
        pauseHelper = false;
    }
}
else {
    pauseHelper = true;
}