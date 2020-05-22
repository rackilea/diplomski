public void run() {
    while (isRunning) {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                long time = getElapsedTime();
                sidePanel.this.clock.setText(String.valueOf(time));
            }
        });
        // Because we really don't want to bombboard the Event dispatching thread
        // With lots of updates, which probably won't get rendered any way,
        // We put in a small delay...

        // This day represents "about" a second accuracy...
        try {
            Thread.sleep(500);
        } catch (Exception exp) {
        }
    }
}