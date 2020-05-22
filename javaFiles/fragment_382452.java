public void buttonPressed(ButtonValues b) {
    switch(b) {
        case MAINMENU_PLAY:
            beginGame();
        case MAINMENU_MAPDESIGNER:
            switchToMapDesigner();
    }
}