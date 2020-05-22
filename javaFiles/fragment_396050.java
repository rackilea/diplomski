Thread t = new Thread() {
     public void run () {
        SleeperMillis.sleepInMillis(new Duration(10000000l));
     }
 }.start();
 Thread.sleep(100); // let the other thread start
 t.interrupt;