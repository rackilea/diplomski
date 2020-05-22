public void run() {
    while(true)
    {
        for (Bullet b : bullets) {
            b.update();
        }
        repaint();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}