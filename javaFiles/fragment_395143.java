public enum Status { 
  VALID("valid")

  private final String val;

  Status(String val) {
    this.val = val;
  }

  public String getStatus() {
    return val;
  }

  public boolean isValid() {
    return this == VALID;
  }

}