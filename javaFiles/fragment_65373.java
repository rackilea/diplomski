protected boolean keyControl(char key, int status, int time) {
    switch (key) {
        case Characters.CONTROL_VOLUME_UP:
            // Do something
            return true;
        case Characters.CONTROL_VOLUME_DOWN:
            // Do something
            return true;
        default:
            return super.keyCharUnhandled(key, status, time);
    }
}