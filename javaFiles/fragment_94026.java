public class Test {
    public static void main(String[] args) {
        try {
            final Document document = printEmotionML("What was that all about?", "angry");
            printDocument(document, System.out);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static Document printEmotionML(String sentence, String emotion) {
        Document emotiondoc = null;
        try {

            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder =
                    dbFactory.newDocumentBuilder();
            emotiondoc = dBuilder.newDocument();

            Element rootElement = emotiondoc.createElementNS("http://www.w3.org/2009/10/emotionml", "emotionml");
            rootElement.setAttribute("version", "1.0");
            emotiondoc.appendChild(rootElement);

            Element emotionEl = emotiondoc.createElement("emotion");
            rootElement.appendChild(emotionEl);

            final Element category = emotiondoc.createElement("category");
            emotionEl.appendChild(category);
            category.setAttribute("emotion", emotion);

            emotionEl.appendChild(emotiondoc.createTextNode(sentence));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return emotiondoc;
    }

    public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        transformer.transform(new DOMSource(doc),
                new StreamResult(new OutputStreamWriter(out, "UTF-8")));
    }

}