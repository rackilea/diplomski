public void drawCircles(Graphics2D g2d, int width, int height) {
    //draw 10 of them
    for(int i = 0; i < 10; i++) {
        //select a random size
        int x = 10 + (int) (Math.random() * 10);
        //draw circle at random position with the created size
        g2d.fillOval((int) (Math.random() * width), (int) (Math.random() * height), x, x);
    }
}