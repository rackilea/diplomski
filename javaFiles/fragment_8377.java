double x = Settings.getWindowX();
double y = Settings.getWindowY();
double h = Settings.getWindowH();
double w = Settings.getWindowW();

primaryStage.setScene(mainScene);

if (Screen.getScreensForRectangle(x, y, w, h).isEmpty()) {

    // no screen intersects saved values...
    // just center on primary screen:

    primaryStage.centerOnScreen();

} else {    

    primaryStage.setX(x);
    primaryStage.setY(y);
    primaryStage.setWidth(w);
    primaryStage.setHeight(h);

}