URL url = new URL("http://example.com");

// Five seconds
int timeout = 5000;

URLConnection connection = url.openConnection();
connection.setConnectTimeout(timeout);
connection.setReadTimeout(timeout);

editorPane.setContentType("text/html");
try (InputStream stream = connection.getInputStream()) {
    editorPane.read(stream, editorPane.getDocument());
} catch (ChangedCharSetException e) {
    String newContentType = e.getCharSetSpec();
    editorPane.setContentType(newContentType);

    EditorKit editorKit = editorPane.getEditorKit();
    Document doc = editorKit.createDefaultDocument();
    doc.putProperty("IgnoreCharsetDirective", true);
    editorPane.setDocument(doc);

    String charset;
    try {
        charset = new DataFlavor(newContentType).getParameter("charset");
    } catch (ClassNotFoundException ce) {
        throw new IOException(ce);
    }

    connection = url.openConnection();
    connection.setConnectTimeout(timeout);
    connection.setReadTimeout(timeout);

    try (Reader reader =
        new InputStreamReader(connection.getInputStream(), charset)) {

        editorKit.read(reader, doc, 0);
    } catch (BadLocationException le) {
        throw new IOException(le);
    }
}