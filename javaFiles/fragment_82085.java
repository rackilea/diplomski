Source source = new DOMSource(doc);
Result result = new StreamResult(new File(fileName));
Transformer xformer;
try {
    xformer = TransformerFactory.newInstance().newTransformer();
    xformer.transform(source, result);
} catch (TransformerConfigurationException e) {
    // TODO Auto-generated catch block
} catch (TransformerFactoryConfigurationError e) {
    // TODO Auto-generated catch block
} catch (TransformerException e) {
    // TODO Auto-generated catch block
}