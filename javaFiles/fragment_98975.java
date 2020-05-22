public void insertString(int offs, String str, AttributeSet a)
    throws BadLocationException {
  if (str == null) {
    return;
  }
  super.insertString(offs, str.replaceAll("[^0-9]", ""), a);
}