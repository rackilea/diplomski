SwingUtilities.invokeAndWait(new Runnable() {
    public void run() {
        new SplashScreen();
    }
});
// Code to start system (nothing that touches the GUI)
SwingUtilities.invokeAndWait(new Runnable() {
    public void run() {
        new MainFrame();
    }
});
//.. etc