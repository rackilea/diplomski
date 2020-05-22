jTextPane1.addCaretListener(new CaretListener() {
        public void caretUpdate(CaretEvent evt) {
            if(evt.getDot() == evt.getMark())return;

    JTextPane txtPane = (JTextPane) evt.getSource();
    DefaultHighlighter highlighter = (DefaultHighlighter) txtPane.getHighlighter();
    highlighter.removeAllHighlights();
    DefaultHighlightPainter hPainter = new DefaultHighlightPainter(new Color(0xFFAA00));
    String selText = txtPane.getSelectedText();
    String contText = "";// = jTextPane1.getText();

    DefaultStyledDocument document = (DefaultStyledDocument) txtPane.getDocument();

    try {
        contText = document.getText(0, document.getLength());
    } catch (BadLocationException ex) {
        Logger.getLogger(JTextPaneTest.class.getName()).log(Level.SEVERE, null, ex);
    }

    int index = 0;

    while((index = contText.indexOf(selText, index)) > -1){

        try {
            highlighter.addHighlight(index, selText.length()+index, hPainter);
            index = index + selText.length();
        } catch (BadLocationException ex) {
            Logger.getLogger(JTextPaneTest.class.getName()).log(Level.SEVERE, null, ex);
           //System.out.println(index);
        }
       }
        }
    });