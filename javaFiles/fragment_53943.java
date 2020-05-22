class User {
  // Marked `volatile` to ensure all writes are visible to other threads.
  volatile String something;

  public void setSomething(String something) {
    this.something = something;
  }

}