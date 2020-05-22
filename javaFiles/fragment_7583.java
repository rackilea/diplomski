if (text.substring(0,1).matches("[0-9]")) {
  int charCount = Integer.parseInt(text.substring(0, 1));
  String text2 = text;
  if (text.length() > charCount) {
    text2 = text.substring(0, charCount);
  }
  System.out.println(text2);
}