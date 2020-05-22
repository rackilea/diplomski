@Persist
private void persist() {
  strMyElement = myElement.toString();
}

@Validate
private void validate() {
  myElement = myElement.fromString(strMyElement);
}