public static void main(String[] args) {
    File currentDir = new File("/Users/Desktop/Class"); // current directory
    displayDirectoryFiles(currentDir);
}

public static void displayDirectoryFiles(File dir) {
    try {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("directory:" + file.getCanonicalPath());
                displayDirectoryContents(file);
            } else {
                System.out.println("     file:" + file.getCanonicalPath());
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}