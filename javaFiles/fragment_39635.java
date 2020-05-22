public String readTextFile(File pFile) {
    try {
        FileInputStream FIO = new FileInputStream(pFile);
        ... // Do the reading and return
    } catch (FileNotFoundException E) {
        System.err.println("The file is not found");
    }
}