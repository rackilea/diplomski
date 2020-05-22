private int statusBar() {
    Rect rectgle= new Rect();
    Window window= getWindow();
    window.getDecorView().getWindowVisibleDisplayFrame(rectgle);
    int statusBar = rectgle.top;
    return statusBar;
}