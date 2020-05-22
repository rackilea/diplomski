public class Chopstick {
  private final Semaphore chopsticksAvailable = new Semaphore(1);

  Chopstick() {
    // Nothing
  }

  // Pick up chopstick
  public void pickUpChopstick() throws InterruptedException {
    chopsticksAvailable.acquire();
  }

  // Release chopstick
  public void releaseChopstick() {
    chopsticksAvailable.release();
  }
}