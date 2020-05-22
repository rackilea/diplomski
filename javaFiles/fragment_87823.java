try (InputStream is = getClass().getResourceAsStrea("/chap.pdf")) {
    try (BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(...)) {
        // Write contents like you would any file
    }
} catch (IOException exp) {
    exp.printStackTrace();
}