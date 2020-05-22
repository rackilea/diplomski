private int topx, topy, vx, vy, r, x, y;

public Top() {
    r = 20;
    topx = r;
    topy = r;
    vx = 10;
    vy = 12;

    /*THREAD.. PROBLEMS IN HERE I THINK*/
    final Thread zipThread = new Thread() {
        @Override
        public void run() {
            while (true) {
                if (topx - r < 0) {
                    vx = -vx;
                    topx = r;
                } else if (topx + r > 300) {
                    vx = -vx;
                    topx = 300 - r;
                }

                if (topy - r < 0) {
                    vy = -vy;
                    topy = r;
                } else if (topy + r > 300) {
                    vy = -vy;
                    topy = 300 - r;
                }
                x += vx;
                y += vy;
                repaint();
                try {
                    Thread.sleep(30);
                } catch (final InterruptedException ex) {
                }
            }
        }
    };
    zipThread.start();
}

public void paintComponent(final Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.ORANGE);
    g.fillOval(x, y, r, r);
}