public static void sendChar(WebElement element, String value) {
  element.clear();

  for (int i = 0; i < value.length(); i++) {
    char c = value.charAt(i);
    String s = new StringBuilder().append(c).toString();
    element.sendKeys(s);
  }
}