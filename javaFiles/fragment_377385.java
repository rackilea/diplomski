void parseNodeContent(Node node) {
  while (true) {
    if (tokenizer.tryConsumeText()) {
      node.appendText(getCurrentText());
    } else if (tryConsumeStartTagStart()) {
      node.append(parseElement());
    } else if

      ...  // processing instructions, entity references

    } else {
      // Let the caller deal with all the rest, including errors.
      break;
    }
  }
}