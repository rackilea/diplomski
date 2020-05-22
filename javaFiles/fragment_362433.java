try {
  int num = Integer.parseInt(value);

  if (num <= 0) {
    throw new NumberFormatException();
  }
} catch (NumberFormatException e) {
    errors.rejectValue(FIELD_FILE, INVALID_MESSAGE_KEY, new Object[]{lineNumber, fieldName}, "Line {0}: {1} must be a positive integer");
}