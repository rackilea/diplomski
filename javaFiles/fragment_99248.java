public static HtmlAnchor myFindAnchor(String text) {
  try {
    return getAnchorByText(text);
  } catch (ElementNotFoundException) {
    return null;
  }
}