void myMethod() throws IOException {
    try {
        //code
    }
    catch(IOException e) {
        LOGGER.error("IOException exception happened");
        throw e;
    }
}