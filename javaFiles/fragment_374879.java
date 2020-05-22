SwingUtilities.invokeAdWait(
    new Runnable() {
        @Override public void run() {
            // the work to be performed by the EDT goes here
            Frame.frame.pack();
            Frame.frame.setVisible(true);
        }
    }
);