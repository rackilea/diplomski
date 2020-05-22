class XmlTokenizer {
  String getCurrentText();
  boolean tryConsumeStartTagStart();
  boolean tryConsumeAttributeName();
  boolean tryConsumeText();
  ...