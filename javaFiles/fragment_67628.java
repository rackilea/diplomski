public static java.util.Timer switchToBusyCursor(final Window frame) {
    startEventTrap(frame);
    java.util.TimerTask timerTask = new java.util.TimerTask() {

        public void run() {
            startWaitCursor(frame);
        }

    };
    final java.util.Timer timer = new java.util.Timer();
    timer.schedule(timerTask, DELAY_MS);
    return timer;
}

public static void switchToNormalCursorEventThread(final Window window, final java.util.Timer timer) {

    Runnable r = new Runnable() {

        public void run() {
            switchToNormalCursor(window, timer);
        }

    };

    javax.swing.SwingUtilities.invokeLater(r);

}

public static void switchToNormalCursor(final Window window, final java.util.Timer timer) {
    timer.cancel();
    stopWaitCursor(window);
    //stopEventTrap(window);
}

private static void startWaitCursor(Window window) {
    ((RootPaneContainer) window).getGlassPane().setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
    ((RootPaneContainer) window).getGlassPane().addMouseListener(mouseAdapter);
    ((RootPaneContainer) window).getGlassPane().setVisible(true);
}

private static void stopWaitCursor(Window window) {
    ((RootPaneContainer) window).getGlassPane().setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));
    //((RootPaneContainer) window).getGlassPane().removeMouseListener(mouseAdapter);
    //((RootPaneContainer) window).getGlassPane().setVisible(false);
}

private static void startEventTrap(Window window) {
    ((RootPaneContainer) window).getGlassPane().addMouseListener(mouseAdapter);
    ((RootPaneContainer) window).getGlassPane().setVisible(true);
}

private static void stopEventTrap(Window window) {
    java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue();
    ((RootPaneContainer) window).getGlassPane().removeMouseListener(mouseAdapter);
    ((RootPaneContainer) window).getGlassPane().setVisible(false);
}

private static final java.awt.event.MouseAdapter mouseAdapter = new java.awt.event.MouseAdapter() {
};