public void closeWindow() {
    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    setVisible(false);
    dispose();
}

public void closeApplication() {
    System.exit(0);
}