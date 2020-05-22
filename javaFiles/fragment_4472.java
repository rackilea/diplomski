private String getDocumentString(Document doc)
{
    String ret = null;
    DOMSource domSource = new DOMSource(doc);
    StringWriter writer = new StringWriter();
    StreamResult result = new StreamResult(writer);
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer;
    try
    {
        transformer = tf.newTransformer();
        transformer.transform(domSource, result);
        ret = writer.toString();
    }
    catch (TransformerConfigurationException e)
    {
        e.printStackTrace();
    }
    catch (TransformerException e)
    {
        e.printStackTrace();
    }
    return ret;
}