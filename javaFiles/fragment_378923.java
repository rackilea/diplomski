public void run() {
    while(true) {
        try {
          runOne();
        } catch(Throwable t) {
          // log t
        }
    }
}