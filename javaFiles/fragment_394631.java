final class SoundPlayer {

  private final Lock lock = new ReentrantLock();

  ...

  void play(SomeTypeRepresentingTheSound clip) {
    if (lock.tryLock()) {
      try {
        /* Play clip. */
        ...
      } finally {
        lock.unlock();
      }
    }
  }

}