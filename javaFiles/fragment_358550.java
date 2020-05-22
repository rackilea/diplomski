InputStream input = ... // your JSON input;
OutputStream output = System.out;
try {
    /*
     * Create source.
     */
    XMLInputFactory inputFactory = new JsonXMLInputFactory();
    inputFactory.setProperty(JsonXMLInputFactory.PROP_MULTIPLE_PI, false);
    Source source = new StAXSource(inputFactory.createXMLStreamReader(input));

    /*
     * Create result.
     */
    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
    XMLStreamWriter writer = outputFactory.createXMLStreamWriter(output);
    writer = new PrettyXMLStreamWriter(writer); // format output
    Result result = new StAXResult(writer);

    /*
     * Transform (copy).
     */
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    transformerFactory.newTransformer().transform(source, result);
} finally {
    /*
     * As per StAX specification, XMLStreamReader/Writer.close() doesn't close
     * the underlying stream.
     */
    output.close();
    input.close();
}