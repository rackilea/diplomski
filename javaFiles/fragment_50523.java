public void run() {
    try {
        while(true) {
            if(sometimesTrue) {
               updateArray();
            }
            Thread.sleep(100);
        }
    } catch (InterruptedException e) {
      // ... do something with e 
    }
}