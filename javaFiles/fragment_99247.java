HtmlAnchor anchor = null;
try {
  htmlAnchor = getAnchorByText(text);
} catch (ElementNotFoundException) {
  // do nothing
}