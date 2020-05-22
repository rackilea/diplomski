public static String readResponseFromFile() throws IOException {
    File path = "some_path";
    File file = new File(path, "/" + "some.file");
    path.mkdirs();
    String response = null;

    if (file != null) {
        InputStream os = new FileInputStream(file);
        try {
            byte[] bytes = new byte[(int) file.length()];
            os.read(bytes);
            response = new String(bytes);
            os.close();

        } catch (IOException ioEx) {
            throw ioEx;
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
    return response;
}