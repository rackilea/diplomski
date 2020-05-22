private static String getResourceFile(final String filename) {
    final InputStream input = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(filename);

    final StringWriter writer = new StringWriter();
    try {
        IOUtils.copy(input, writer, "utf-8");
    } catch (final IOException e) {
        System.out.println("Error reading: " + filename);
    }
    return writer.toString();
}