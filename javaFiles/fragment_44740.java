public void createXml(String src, String dest) throws IOException {
    PdfReader reader = new PdfReader(src);
    List<HashMap<String, Object>> list = SimpleBookmark.getBookmark(reader);
    SimpleBookmark.exportToXML(list,
            new FileOutputStream(dest), "ISO8859-1", true);
    reader.close();
}