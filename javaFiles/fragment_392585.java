final URLStreamHandler streamHandler = new URLStreamHandler() {

    @Override
    protected URLConnection openConnection(URL u)
        throws IOException {
        return null;
    }

};

try {
    getAppletContext().showDocument(
        new URL(null, "javascript:alert('It works!');", streamHandler));
} catch (MalformedURLException me) {
    //log or whatever
}