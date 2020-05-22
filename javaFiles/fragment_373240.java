class FileNameFilter extends DocumentFilter {
  public void insertString (DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
    fb.insertString (offset, fixText(text), attr);
}

  public void replace (DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attr) throws BadLocationException {
    fb.replace(offset, length, fixText(text), attr);
  }

  private String fixText(String s) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < s.lenght(); ++i) {
      if(isLegalFileNameChar(s.charAt(i))
        sb.append(s.charAt(i));
    }

    return sb.toString();
  }

  private boolean isLegalFileNameChar(char c) { 
    // Your logic goes here ...
  }
}