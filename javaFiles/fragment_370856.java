public Game() {
    (new Thread() {
        public void run() {
            draw();
        }
     ).start();
 }

private void draw() {
    while(true) {
        moveBall();
        repaint();
        try {
            System.out.println("inside thread");
            Thread.sleep(2000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}