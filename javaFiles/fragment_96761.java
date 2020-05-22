static boolean isLocked(String fileName) {
    FileStore fs = new FileStore();
    try {
        fs.open(fileName, true, null);
        return false;
    } catch (IllegalStateException e) {
        return true;
    } finally {
        fs.close();
    }
}