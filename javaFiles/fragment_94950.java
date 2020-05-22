private int getFileNums(File file) {
    if (file.isDirectory()) {
        File [] files = file.listFiles();
        if (files != null) {
            int count = 0;
            for (File f : files) {
                 if (f.isDirectory()) {
                     count += getFileNums(f);
                 } else if (f.getName().toLowerCase().endswith(".rar")) {
                     count++;
                 }
            }
            return count;
        } else {
            return 0;
        }
    } else {
        throw new IllegalArgumentException("Expecting a directory.");
    }
}