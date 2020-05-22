public void pushScreen(String screenName) {
    if (screenName.equals("ScreenA") {
        UiApplication.getUiApplication().pushScreen(new ScreenA());
    } else if (screenName.equals("ScreenB") {
        UiApplication.getUiApplication().pushScreen(new ScreenB());
    } 
    // rest of the codes....