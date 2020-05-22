private static File getFileLastModified(File[] files) {
    File fileLastModified = null;
    long maxLastModified = Long.MIN_VALUE;
    for (File file : files) {
        if (file.isDirectory()) {
            final long lastModified = file.lastModified();
            if (lastModified > maxLastModified) {
                fileLastModified = file;
                maxLastModified = lastModified;
            }
        }
    }
    return fileLastModified;
}