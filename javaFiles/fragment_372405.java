Document d = out.outputW3CDom(converted);
            DOMSource oldDocument = new DOMSource(d);
            DOMResult newDocument = new DOMResult();
            TransformerFactory tf = TransformerFactory.newInstance();
            StreamSource xsltsource = new StreamSource(
                    getStream(MEDIA_RSS_TRANSFORM_XSL));
            Transformer transformer = tf.newTransformer(xsltsource);
            transformer.transform(oldDocument, newDocument);

private InputStream getStream(String fileName) {
    InputStream xslStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("/" + fileName);
    if (xslStream == null) {
        xslStream = Thread.currentThread().getContextClassLoader()      .getResourceAsStream(fileName);
        }
        return xslStream;
    }