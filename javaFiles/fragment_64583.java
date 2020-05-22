if (!file.exists()) {
    Console console = System.console();
    if (console != null) {
        console.format("File doesn't exists%n");
    } else if (!GraphicsEnvironment.isHeadless()) {
        JOptionPane.showMessage(null, "File doesn't exists");
    } else {
        // Put it in the log
    }
 }