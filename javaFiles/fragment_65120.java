private static long getDirSize(File srcDir) {
    long sum = 0;
    if (srcDir.isFile()) {
        sum += srcDir.length();
    } else {
        for (File curFile : srcDir.listFiles()) {
            sum += getDirSize(curFile);
        }
    }
    return sum;
}