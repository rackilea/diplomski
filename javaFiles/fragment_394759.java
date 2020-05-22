public void writeToOutputStream(Document fDoc, OutputStream out) throws Exception {
    fDoc.setXmlStandalone(true);
    DOMSource docSource = new DOMSource(fDoc);
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty(OutputKeys.INDENT, "no");
    transformer.transform(docSource, new StreamResult(out));
}