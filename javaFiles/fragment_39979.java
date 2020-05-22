InputStream is = new FileInputStream("test.xml") {
    @Override
    public void close() throws IOException {
        System.out.println("close");
        super.close();
    }
};
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
documentBuilder.parse(is);