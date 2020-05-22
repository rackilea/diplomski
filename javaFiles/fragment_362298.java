public static void main() {
        File baseDir = new File(System.getProperty("java.io.tmpdir"));
        File tempDir = new File(baseDir, "test0");
        System.err.println(tempDir.getAbsolutePath());

        tempDir.mkdir();

        System.err.println("is it a dir? " + tempDir.isDirectory());
        System.err.println("does it exist? " + tempDir.exists());
    }