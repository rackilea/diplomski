DefaultStyledDocument document = (DefaultStyledDocument) jTextPane1.getDocument();
try {
    contText = document.getText(0, document.getLength());
} catch (BadLocationException ex) {
     Logger.getLogger(JTextPaneTest.class.getName()).log(Level.SEVERE, null, ex);
 }