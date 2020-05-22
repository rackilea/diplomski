public enum HttpStatus {
  CODE_404("Not Found"),
  CODE_500("Internal Server Error");

  private final String description;

  HttpStatus(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}