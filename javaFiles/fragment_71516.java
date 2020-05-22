class MyHTMLReader extends HTMLDocument.HTMLReader {
    public MyHTMLReader(int offset) {
        super(offset);
    }
    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        if (t.toString().equals("button")) {
            registerTag(t, new BlockAction());
        }
        super.handleStartTag(t, a, pos);
    }
}