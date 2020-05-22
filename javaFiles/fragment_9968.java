public static enum AnswerType {
  TEXT("string") {
    public boolean isValid(String answer) { return !StringUtils.isEmpty(answer); }
  },
  INT("integer") {
    public boolean isValid(String answer) { return NumberUtils.isDigits(answer); }
  },
  FLOAT("float") {
    public boolean isValid(String answer) { return NumberUtils.isNumber(answer); }
  };

  private final String type;

  AnswerType(final String type) {
    this.type = type;
  }

  /**
   * Checks whether the given answer is valid for this answer type.
   *
   * @param answer The provided answer.
   *
   * @return true if the answer is valid; false otherwise.
   */
  public abstract boolean isValid(final String answer);
}