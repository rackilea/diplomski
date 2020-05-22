public void writeToXmlFile(String xmlContent) {
    File theDir = new File("./output");
    if (!theDir.exists())
        theDir.mkdir();

    String fileName = "./output/" + this.getClass().getSimpleName() + "_"
            + Calendar.getInstance().getTimeInMillis() + ".xml";

    try (OutputStream stream = new FileOutputStream(new File(fileName))) {
        try (OutputStreamWriter out = new OutputStreamWriter(stream, StandardCharsets.UTF_16)) {
            out.write(xmlContent);
            out.write("\n");
        }
    } catch (IOException ex) {
        System.err.println("Cannot write to file!", ex);
    }
}