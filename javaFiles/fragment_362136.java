URL url = new URL("http://example.com");

// Five seconds
long timeout = 5000;

URLConnection connection = url.openConnection();
connection.setConnectTimeout(timeout);
connection.setReadTimeout(timeout);

editorPane.setContentType("text/html");
try (InputStream stream = connection.getInputStream()) {
    editorPane.read(stream, editorPane.getDocument());
}