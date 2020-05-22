try {
    FileInputStream fis = context.openFileInput("file_name");
    int content;
    StringBuilder str = new StringBuilder();
    while ((content = fis.read()) != -1)
        str.append((char) content);
    fis.close();
    String savedText = str.toString();
} catch (IOException e) {
    e.printStackTrace();
}