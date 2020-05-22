public void run() {
    while(run==true) {
        try {
            Thread.sleep(20);
        }
        catch(Exception e) { };
        repaint();
    }
}