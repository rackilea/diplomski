public static enum AnswerType {
  TEXT("string", s -> !StringUtils.isEmpty(s)),
  INT("integer", NumberUtils::isDigits),
  FLOAT("float", NumberUtils::isNumber);

  private final String type;
  private final Predicate<String> isValid;

  AnswerType(final String type, Predicate<String> isValid) {
    this.type = type;
    this.isValid = isValid;
  }

  /**
   * Checks whether the given answer is valid for this answer type.
   *
   * @param answer The provided answer.
   *
   * @return true if the answer is valid; false otherwise.
   */
  public boolean isValid(final String answer) {
    return isValid.test(answer);
  }
}