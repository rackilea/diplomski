class camThread extends Thread {

    @Override
    public void run() {
        for (;;) {
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
            }
        }
    }
}