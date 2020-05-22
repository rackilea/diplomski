InputStream is = null;

Thread worker = new Thread() {
    // show "loading..."
    public void run() {
        try {
            URL url = new URL("http://stackoverflow.com/");
            is = url.openStream();
        } catch (InterruptedException ex) { ... }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // show "done" or remove "loading..."
            }
        });
    }
};
worker.start();