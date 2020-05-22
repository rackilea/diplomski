private void sleep() {
      try {
          Thread.sleep(1000);
      } catch (InterruptedException e) {
          throw new IllegalStateException(e);
      }
    }