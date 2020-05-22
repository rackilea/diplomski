File folder = new File("yourFolder");

while (true) {
    File[] files = folder.listFiles(new TextFileFilter());
    if (files.length > 0) // found;
}