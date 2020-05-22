public boolean isRock(String input) {
      String lower = input.toLowerCase();
      return lower.equals("r") || lower.equals("rock");
  }

  public boolean isPaper(String input) {
      String lower = input.toLowerCase();
      return lower.equals("p") || lower.equals("paper");
  }

  public boolean isScissors(String input) {
      String lower = input.toLowerCase();
      return lower.equals("s") || lower.equals("scissors");
  }

  public boolean isValid(String input) {
      return isRock(input) || isPaper(input) || isScissors(input);
  }