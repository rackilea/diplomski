// Precondition: on element start
// Postcondition: on element end
Element parseElement() {
  Element result = new Element(tokenizer.getCurrentText());
  while (tryConsumeAttributeName()) {
    String attributeName = tokenizer.getCurrentText();

    ... // attribute value parsing

  }
  if (!tokenizer.tryConsumeStartTagEndSelfClosing()) {
    if (!tokenizer.tryConsumeStartTagEnd()) {
      throw new RuntimeException("Invalid start tag end");
    }
    parseContent(result);
    if (!tokenizer.tryConsumeEndTag(result.name())) {
      throw new RuntimeException("End tag missing for " +result.name());
    }
  }
  return result;
}