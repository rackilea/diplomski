public static void displayDirectoryContents(File dir, String rootDir) {
    File[] files = dir.listFiles();
    for (File file : files) {
        if (file.isDirectory()) {
            displayDirectoryContents(file, rootDir);
        } else {
            System.out.println(file.getPath().replaceFirst(rootDir, ""));
        }
    }
}

public static void main(String[] args) throws IOException {
    String rootDir = <rootDir>;
    File currentDir = new File(rootDir);
    displayDirectoryContents(currentDir, rootDir);
}