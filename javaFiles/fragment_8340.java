public void doStuffWithFile() throws IOException {
    Reader reader = new FileReader("/my/file/location");
    try {
        //Read the file and do stuff
    } finally {
        try {
            reader.close();
        } catch (IOException e) {
            // handle the exception so it doesn't mask
            // anything thrown within the try-block
            log.warn("file close failed", e);
        }
    }
}