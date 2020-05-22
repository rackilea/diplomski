String searchedWord = "word";
int pos1 = textArea.getText().indexOf(searchedWord);
int pos2 = pos1 + searchedWord.length();
try {
    textArea.getHighlighter().addHighlight(pos1, pos2,
            new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY));
} catch (BadLocationException e) {
    e.printStackTrace();
}