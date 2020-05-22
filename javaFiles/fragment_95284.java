Screen scr = UiApplication.getUiApplication().getActiveScreen();
if (scr instanceof MyScreen) {
    MyScreen my = (MyScreen) scr;
    my.setlabel(it);
    my.invalidate();
}