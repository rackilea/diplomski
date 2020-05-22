public static void incrementalChoice() throws IOException {
    FileWriter fileWriter = new FileWriter("fileNames.txt");
    PrintWriter printWriter = new PrintWriter(fileWriter);
    File[] fileArray = new File(pathToFiles).listFiles();
    try {
        for(File file : fileArray) {
            fileName = file.toString();
            printWriter.println(fileName);
        }
        printWriter.close();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}