// if you have a huge amount of files in deeply nested directories
// this might need some further tuning
static File getRecentFile(File dir, File baseFile) {
    File recentFile = baseFile;
    for (File file : dir.listFiles()) {
        if (file.isDirectory()) {
            recentFile = getRecentFile(file, recentFile);
        } else {
            if (file.lastModified() > recentFile.lastModified())  {
                recentFile = file;
            }
        }
    }
    return recentFile;
}