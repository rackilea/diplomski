if (c == OK) {
        nextScreen = new RegisterScreen();
        display.setCurrent(nextScreen);
    }
    if (c == BACK) {
        display.setCurrent(prevScreen);
    }