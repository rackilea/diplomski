private int statusBar() {
    Rect rectgle= new Rect();
    Window window= getWindow();
    window.getDecorView().getWindowVisibleDisplayFrame(rectgle);
    int StatusBarHeight= rectgle.top;
    int contentViewTop= 
        window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
    int statusBar = contentViewTop - StatusBarHeight;
    return statusBar;
}