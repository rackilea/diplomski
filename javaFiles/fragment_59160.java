public static String readFile(String xmlFileName) throws IOException, DocumentException {
    try (final InputStream is = new ClassPathResource(xmlFileName).getInputStream()) {
        final SAXReader reader = new SAXReader();
        final Document doc = reader.read(inputStream);
        return doc.asXML();
    }
}