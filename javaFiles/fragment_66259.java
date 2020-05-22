if (source == find) {
    try {
        DefaultHighlighter.DefaultHighlightPainter highlighter = new DefaultHighlighter.DefaultHighlightPainter(UIManager.getColor("TextArea.selectionBackground"));

        MenuFrame.textarea.getHighlighter().addHighlight(n, n + search.length(), highlighter);
    } catch (BadLocationException ex) {
        ex.printStackTrace();
    }
}