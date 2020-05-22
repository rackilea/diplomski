public void enableFineLogging() {
    try {
        ch.ethz.ssh2.log.Logger.enabled = true;
        String name = "myDynamicFileNamePart";

        FileHandler fileHandler = new FileHandler("./logs/"
                + name + "_SFTP.log", 10000000, 1000, true);
        fileHandler.setLevel(Level.FINE);
        fileHandler.setFormatter(new SimpleFormatter());

        final Logger app = Logger.getLogger("ch.ethz");
        app.setLevel(Level.FINE);
        app.addHandler(fileHandler);
        app.setUseParentHandlers(false);

    } catch (Exception e) {
        // Catchalog
    }
}