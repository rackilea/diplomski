void foo() throws SomeCheckedException {
    final AtomicReference<SomeCheckedException> exRef = new AtomicReference<>();
    display.syncExec(new Runnable() {
      public void run() {
        try {
          new Work().something();
        } catch (SomeCheckedException e) {
          exRef.set(e);
        }
      }
    });
    SomeCheckedException ex = exRef.get();
    if (ex != null) {
      throw ex;
    }
  }