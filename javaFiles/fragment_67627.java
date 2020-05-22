private void unlockWindow(RootPaneContainer window) {
    try {
        LockedWindow lockedWindow = lockedWindows.get(window);
        //System.err.println(getThreadPrefix()  + " Unlocking window::: " + lockeWindow.isDisplayable());
        if (lockedWindow != null && ((Frame) window).isDisplayable()) {
            System.err.println(getThreadPrefix() + "Unlocking..." + lockedWindow);
            // Restore the original glasspane for the window

            //okk may be glasspane only in integrated scenario is causing the issue
            //comment it and check, we are still putting it in the map  above but its doing nothing


            //okk is this the only issue? What should be the originalGlassPane first time? null?
            if (lockedWindow.originalGlassPane != null) {
                System.err.println(getThreadPrefix() + "Reset original glass pane.");
                window.setGlassPane(lockedWindow.originalGlassPane);
                //lockedWindow.originalGlassPane.setVisible(true);
            }


            //make content pane visible again.
            //(window).getContentPane().setVisible(lockedWindow.wasVisible);

            //okk try this
            //(window).getContentPane().setVisible(true);
            //(window).getRootPane().invalidate();

            //okk the above thing worked, it doesnt lock naturlly, now try if setting visible code is an issue?
            //great this thing works so this also is not an issue
            (window).getContentPane().setVisible(lockedWindow.wasVisible);

            (window).getRootPane().repaint();

            // Restore (un-minimize) the window if it wasn't minimized before
            // the lock.
            //do this tuff anyways
            if (!lockedWindow.minimized && window instanceof Frame) {
                ((Frame) window).setExtendedState(((Frame) window).getExtendedState()
                        & ~Frame.ICONIFIED);
            }


            // Restore the original default close operation from before the
            // lock, which will normally allow the window to be closed.

            //dont do listeneres??
            if (window instanceof Window) {
                if (lockedWindow.windowListeners != null) {
                    for (WindowListener wl : lockedWindow.windowListeners) {
                        System.err.print("windowlistener is not null " + wl);
                        ((Window) window).addWindowListener(wl);
                    }
                }
                if (window instanceof JFrame) {
                    ((JFrame) window)
                            .setDefaultCloseOperation(lockedWindow.originalDefaultCloseOperation);
                } else if (window instanceof JDialog) {
                    ((JDialog) window)
                            .setDefaultCloseOperation(lockedWindow.originalDefaultCloseOperation);
                } 
            }

            //try this too
            //((RootPaneContainer)window).setGlassPane(null);

            //lockedWindows.remove(window);
          //stopEventTrap
            stopEventTrap((Frame)window);
            System.err.println(getThreadPrefix()  + " Window has been unlocked");
        }
    } catch (Exception e) {
        System.err.println(getThreadPrefix()  + " Failed to unlock window. " + e.getLocalizedMessage());
    }

}