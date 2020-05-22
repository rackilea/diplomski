String[] files = { "file1.txt", "file2.txt", "file3.txt" };
for (String file : files) {
    File f = new File(file);
    String content = FileUtils.readFileToString(new File("filename.txt"));
    FileUtils.writeStringToFile(f, content.replaceAll("hello", "world"));
}