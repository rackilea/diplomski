InputStream input = assetManager.open("android.svg"); //From your asset folder

DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = null;
try {
    builder = factory.newDocumentBuilder();
} catch (ParserConfigurationException e) {
    e.printStackTrace();
}