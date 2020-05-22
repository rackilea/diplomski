JTextArea text=new JTextArea(10,30);
text.getDocument().addDocumentListener(new DocumentListener() {
   @Override
   public void insertUpdate(DocumentEvent arg0) {
   // Handle text entry - just get the text when a newline character is found at the end of the text
   }
});