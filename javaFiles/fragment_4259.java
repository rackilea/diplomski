public class SampleException extends Exception{

  private String message;

  public SampleException() {
  }

  public SampleException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }
}