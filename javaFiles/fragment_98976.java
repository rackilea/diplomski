Document document = someJTextField.getDocument();
if (document instanceof AbstractDocument) {
  ((AbstractDocument) doc).setDocumentFilter(new DocumentFilter() {
    public void insertString(DocumentFilter.FilterBypass fb, int offset,  
        String str, AttributeSet a) throws BadLocationException {  
      fb.insertString(offset, str.replaceAll("[^0-9]", ""), a);  
    }
  });
}