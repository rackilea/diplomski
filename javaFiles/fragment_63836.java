@Override
protected Void doInBackground() {
    try {
        while (true) {
            displayImage(imageA);
            Thread.sleep(1000L);
            if (isCancelled()) {
                return null;
            }
            displayImage(imageB);
            Thread.sleep(200L);
            if (isCancelled()) {
                return null;
            }
        }
    }
    catch (InterruptedException e) {
        // ignore
    }
    return null;
}

private void displayImage(final Icon image) {
    SwingUtilituies.invokeLater(new Runnable() {
        @Override
        public void run() {
            // display the image in the panel
        }
    });
}