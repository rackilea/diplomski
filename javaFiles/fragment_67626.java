private void lockWindow(final Window window) {
    if (window instanceof RootPaneContainer
            && ((RootPaneContainer) window).getRootPane() != null
            && !lockedWindows.containsKey(window)) {
        java.util.Timer timer = null;
        try {

            //don't do invalidate, invalidate as the first step
            //((RootPaneContainer) window).getContentPane().invalidate();

            // Create an object to store original details for the locked window.
            LockedWindow lockedWindow = new LockedWindow();
            lockedWindows.put((RootPaneContainer) window, lockedWindow);

            lockedWindow.originalGlassPane = ((RootPaneContainer) window).getGlassPane();


            //okk may be glasspane only in integrated scenario is causing the issue
            //comment it and check, we are still putting it in the map  above but its doing nothing
            /*
            // Remember the original glass pane and visibility before locking.

            //okk is this the only issue? What should be the originalGlassPane first time? null?
            lockedWindow.originalGlassPane = ((RootPaneContainer) window).getGlassPane();
            System.err.println("Original galss pane : " + ((RootPaneContainer) window).getGlassPane());

            lockedWindow.wasVisible = ((RootPaneContainer) window).getContentPane().isVisible();

            // Add a LockedGlassPane to the window.
            LockedGlassPane lgp = new LockedGlassPane();
            lgp.setVisible(true); //hide the contents of the window
            ((RootPaneContainer) window).setGlassPane(lgp);

            //don't do this stuff too
            ((RootPaneContainer) window).getContentPane().setVisible(false);

            lgp.setVisible(true); //redisplays the lock message after set as glassPane.
            */
            LockedGlassPane lgp = new LockedGlassPane();
            ((RootPaneContainer) window).setGlassPane(lgp);
            timer = switchToBusyCursor(window);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //do nothing
                System.err.println("Am I interrupted?");
            }
            //okk the above thing worked, it doesnt lock naturlly, now try if setting visible code is an issue?
            //great this thing works so this also is not an issue, only galsspane in SiteManager is
            lockedWindow.wasVisible = ((RootPaneContainer) window).getContentPane().isVisible();

            ((RootPaneContainer) window).getContentPane().repaint();

            // Minimize the window (if requested), while keeping a record of
            // which windows have been minimized so that they can be restored
            // later when the TimeoutTarget is unlocked.

          //don't do this stuff too - as unlock is not working investigating that
            if (window instanceof Frame) {
                Frame frame = (Frame) window;
                // Remember the original minimized state of the window.
                lockedWindow.minimized = (frame.getExtendedState() & Frame.ICONIFIED) != 0;
                if (lockMinimized) {
                    frame.setExtendedState(Frame.ICONIFIED);
                }
            }

            //
            //Note required now, but keeping in case the requirement changes again.
            //
            // Prevent the window from being closed while this target is
            // locked.
            // lockedWindow.windowListeners = window.getWindowListeners();
            //  for (WindowListener wl : lockedWindow.windowListeners) {
            //     window.removeWindowListener(wl);
            // }
            //if (window instanceof JFrame) {
            // JFrame jframe = (JFrame) window;
            // lockedWindow.originalDefaultCloseOperation = jframe.getDefaultCloseOperation();
            // jframe.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            //} else if (window instanceof JDialog) {
            //  JDialog jdialog = (JDialog) window;
            // lockedWindow.originalDefaultCloseOperation = jdialog.getDefaultCloseOperation();
            // jdialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            //}
        } catch (Exception e) {
            System.err.println(getThreadPrefix()  + " Failed to lock window." + e.getLocalizedMessage());
        } finally {
            switchToNormalCursorEventThread(window, timer);
        }
    }        
}