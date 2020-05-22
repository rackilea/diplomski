private boolean isNumeric(String text) {
   text = text.trim();
   if(",".equals(text)) return true;
   ParsePosition position = new ParsePosition(0);
   java.text.NumberFormat.getNumberInstance().parse(text, position);
   return position.getIndex() == text.length();
}