public static File Test1;
public static File Test2;

public static void main(String[] args) {
    File file = new File("\\\\your\\file\\path");
    searchFiles(file);
    System.out.println(Test1);
    System.out.println(Test2);
}

public static void searchFiles(File directory) {
    if (directory.isDirectory()) {
        File[] subDirectories = directory.listFiles();
        for (File file : subDirectories) {
            searchFiles(file);
        }
    } else {
        if (Test1 == null) {
            if (directory.getName().contains("Test_1")) {
                Test1 = directory;
            }
        }
        if (Test2 == null) {
            if (directory.getName().contains("Test_2")) {
                Test2 = directory;
            }
        }
        if (directory.getName().contains("Test_1") && directory.lastModified() > Test1.lastModified()) {
            Test1 = directory;
        }
        if (directory.getName().contains("Test_2") && directory.lastModified() > Test2.lastModified()) {
            Test2 = directory;
        }
    }
}