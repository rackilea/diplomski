private String cleanData(String data) throws UnsupportedEncodingException {
    Tidy tidy = new Tidy();
    tidy.setInputEncoding("UTF-8");
    tidy.setOutputEncoding("UTF-8");
    tidy.setPrintBodyOnly(true); // only print the content
    tidy.setXmlOut(true); // to XML
    tidy.setSmartIndent(true); 
    ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes("UTF-8"));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    tidy.parseDOM(inputStream, outputStream);
    return outputStream.toString("UTF-8");
}