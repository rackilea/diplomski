class SaveThatCommand implements Runnable {
     private final StatusWindow s;
     //constructor that initializes s
     public void run() {
        //save that code
        s.update();
     }
}