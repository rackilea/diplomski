public abstract class Actor {
  private Status status;

  public Actor() {
    status = new Status(); // default empty status
  }


  public Actor(Status status) {
    this.status = status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Status getStatus() {
    return status;
  }
}