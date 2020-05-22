public boolean isStillOpenOnWindows(File file) {
    try {
        FileOutputStream out = new FileOutputStream(file, true);
        out.close();
        // Not open anymore
        return false;
    } catch (IOException e) {
        // Still open
        return true;
    }
}