public String getUniqueFileName(String input) {
    String base = "F:/unprocessed/";

    String filename = base+input;

    File file = new File(filename);
    int version = 0;
    while (file.exists()) {
        version++;
        String filenamebase = filename.substring(0, filename.lastIndexOf('.'));
        String extension = filename.substring(filename.lastIndexOf('.'));
        file = new File(filenamebase+"("+ version+")"+extension);
    }
    return file.getAbsolutePath();
}