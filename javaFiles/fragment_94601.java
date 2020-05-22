private int getTotalFiles(String path) {
    //...
    if (f.isFile()) {
        countFiles++;
    }
    if (f.isDirectory()) {
        countFiles += getTotalFiles(path);
    }
}